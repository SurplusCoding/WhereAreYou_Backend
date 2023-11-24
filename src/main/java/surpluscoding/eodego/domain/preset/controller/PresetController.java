package surpluscoding.eodego.domain.preset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import surpluscoding.eodego.domain.preset.service.PresetService;
import surpluscoding.eodego.domain.user.controller.dto.StatusRequestDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/preset")
public class PresetController {

    private final PresetService presetService;

    @PostMapping
    public Long create(@RequestBody StatusRequestDto statusRequestDto) {
        return presetService.createPreset(statusRequestDto);
    }
}
