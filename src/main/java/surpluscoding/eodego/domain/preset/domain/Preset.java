package surpluscoding.eodego.domain.preset.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import surpluscoding.eodego.domain.user.controller.dto.StatusRequestDto;
import surpluscoding.eodego.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor
public class Preset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private String howLong;

    @Column(nullable = false)
    private String what;

    @Builder
    public Preset(User user, String place, String howLong, String what) {
        this.user = user;
        this.place = place;
        this.howLong = howLong;
        this.what = what;
    }

    public Preset update(StatusRequestDto statusRequestDto) {
        place = statusRequestDto.place();
        howLong = statusRequestDto.howLong();
        what = statusRequestDto.what();
        return this;
    }
}
