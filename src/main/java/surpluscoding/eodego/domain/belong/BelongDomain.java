package surpluscoding.eodego.domain.belong;

import jakarta.persistence.*;
import surpluscoding.eodego.domain.group.GroupDomain;
import surpluscoding.eodego.domain.user.UserDomain;

@Entity
public class BelongDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private UserDomain userId;

    @ManyToOne
    private GroupDomain groupId;
}
