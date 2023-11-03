package surpluscoding.eodego.domain.group;

import jakarta.persistence.*;

@Entity
public class GroupDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;

    @Column(nullable = false)
    private String name;
}
