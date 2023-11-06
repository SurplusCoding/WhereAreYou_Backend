package surpluscoding.eodego.domain.belong.domain;

import jakarta.persistence.*;
import surpluscoding.eodego.domain.team.domain.Group;
import surpluscoding.eodego.domain.user.domain.User;

@Entity
public class Belong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Group teamId;
}
