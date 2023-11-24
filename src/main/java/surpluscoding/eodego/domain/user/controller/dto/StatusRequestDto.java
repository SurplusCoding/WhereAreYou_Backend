package surpluscoding.eodego.domain.user.controller.dto;

import surpluscoding.eodego.domain.preset.domain.Preset;
import surpluscoding.eodego.domain.user.domain.User;

public record StatusRequestDto(
        String place,
        String howLong,
        String what
) {
    public Preset toEntity(User user) {
        return Preset.builder()
                .user(user)
                .place(place)
                .howLong(howLong)
                .what(what)
                .build();
    }
}
