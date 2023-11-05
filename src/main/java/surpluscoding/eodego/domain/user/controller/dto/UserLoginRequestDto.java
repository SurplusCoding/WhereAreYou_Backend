package surpluscoding.eodego.domain.user.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserLoginRequestDto {
    private String email;
    private String password;

    //public User toEntity()
}
