package surpluscoding.eodego.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import surpluscoding.eodego.domain.preset.controller.dto.StatusRequestDto;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String place;

    private String howLong;

    private String what;

    @Builder
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User update(StatusRequestDto statusRequestDto) {
        place = statusRequestDto.place();
        howLong = statusRequestDto.howLong();
        what = statusRequestDto.what();
        return this;
    }
}
