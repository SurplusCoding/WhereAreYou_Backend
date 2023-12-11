package surpluscoding.eodego.domain.preset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surpluscoding.eodego.domain.preset.controller.dto.PresetResponseDto;
import surpluscoding.eodego.domain.preset.service.PresetService;
import surpluscoding.eodego.domain.preset.controller.dto.StatusRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/preset")
public class PresetController {

    private final PresetService presetService;

    @PostMapping
    public Long create(@RequestBody StatusRequestDto statusRequestDto) {
        return presetService.createPreset(statusRequestDto);
    }

    @PutMapping("/{presetId}")
    public PresetResponseDto update(@PathVariable("presetId") Long presetId, @RequestBody StatusRequestDto statusRequestDto) {
        return presetService.updatePreset(presetId, statusRequestDto);
    }

    @GetMapping
    public List<PresetResponseDto> read() {
        return presetService.getPresets();
    }

    @DeleteMapping("/{presetId}")
    public void delete(@PathVariable("presetId") Long presetId) {
        presetService.deletePreset(presetId);
    }
}
