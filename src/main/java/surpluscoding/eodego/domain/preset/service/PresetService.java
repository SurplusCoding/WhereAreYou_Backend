package surpluscoding.eodego.domain.preset.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.preset.repository.PresetRepository;
import surpluscoding.eodego.domain.user.controller.dto.StatusRequestDto;
import surpluscoding.eodego.domain.user.service.UserGetService;

@Service
@RequiredArgsConstructor
public class PresetService {

    private final PresetRepository presetRepository;
    private final UserGetService userGetService;

    public Long createPreset(StatusRequestDto statusRequestDto) {
        return presetRepository.save(statusRequestDto.toEntity(userGetService.getUser())).getId();
    }
}
