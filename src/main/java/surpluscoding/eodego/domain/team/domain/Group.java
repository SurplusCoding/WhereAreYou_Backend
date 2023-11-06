package surpluscoding.eodego.domain.team.domain;

import jakarta.persistence.*;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    @Column(nullable = false)
    private String name;
}
