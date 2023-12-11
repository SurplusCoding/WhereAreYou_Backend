package surpluscoding.eodego.domain.preset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.preset.controller.dto.PresetResponseDto;
import surpluscoding.eodego.domain.preset.domain.Preset;
import surpluscoding.eodego.domain.preset.repository.PresetRepository;
import surpluscoding.eodego.domain.preset.controller.dto.StatusRequestDto;
import surpluscoding.eodego.domain.user.service.UserGetService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresetService {

    private final PresetRepository presetRepository;
    private final UserGetService userGetService;

    public Long createPreset(StatusRequestDto statusRequestDto) {
        return presetRepository.save(statusRequestDto.toEntity(userGetService.getUser())).getId();
    }

    public PresetResponseDto updatePreset(Long presetId, StatusRequestDto statusRequestDto) {
        Preset preset = presetRepository.findById(presetId).orElseThrow(() -> new RuntimeException("프리셋 아이디가 존재하지 않습니다."));
        return new PresetResponseDto(presetRepository.save(preset.update(statusRequestDto)));
    }

    public List<PresetResponseDto> getPresets() {
        Long userId = userGetService.getUserId();
        return presetRepository.findAllByUserId(userId).stream()
                .map(PresetResponseDto::new)
                .toList();
    }

    public void deletePreset(Long presetId) {
        presetRepository.deleteById(presetId);
    }
}
