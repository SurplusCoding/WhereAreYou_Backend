package surpluscoding.eodego.domain.group.domain;

import jakarta.persistence.*;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(nullable = false)
    private String name;
}
