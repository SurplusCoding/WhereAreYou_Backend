package surpluscoding.eodego.domain.user.controller.dto;

import surpluscoding.eodego.domain.user.domain.User;

public record UserRequestDto (
        String name,
        String email,
        String password
) {

    public User toEntity(String password) {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(password)
                .build();
    }
}
