package surpluscoding.eodego.domain.user.controller.dto;

public record UserLoginRequestDto (
        String email,
        String password
) { }
