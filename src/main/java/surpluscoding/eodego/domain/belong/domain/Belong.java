package surpluscoding.eodego.domain.belong.domain;

import jakarta.persistence.*;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.user.domain.User;

@Entity
public class Belong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Team teamId;
}
