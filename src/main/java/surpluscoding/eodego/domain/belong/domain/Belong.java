package surpluscoding.eodego.domain.belong.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor
public class Belong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private User user;

    @ManyToOne
    private Team team;

    @Builder
    public Belong(User user, Team team) {
        this.user = user;
        this.team = team;
    }
}
