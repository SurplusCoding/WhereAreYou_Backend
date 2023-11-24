package surpluscoding.eodego.domain.preset.controller.dto;

import surpluscoding.eodego.domain.preset.domain.Preset;

public record PresetResponseDto(
        Long presetId,
        String place,
        String howLong,
        String what
) {
    public PresetResponseDto(Preset preset) {
        this(
                preset.getId(),
                preset.getPlace(),
                preset.getHowLong(),
                preset.getWhat()
        );
    }
}
