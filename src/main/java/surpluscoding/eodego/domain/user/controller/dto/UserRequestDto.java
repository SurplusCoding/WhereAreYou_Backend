package surpluscoding.eodego.domain.user.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import surpluscoding.eodego.domain.user.domain.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String name;
    private String email;
    private String password;

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .build();
    }
}
