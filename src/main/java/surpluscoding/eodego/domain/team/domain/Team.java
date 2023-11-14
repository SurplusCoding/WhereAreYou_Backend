package surpluscoding.eodego.domain.team.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String manager;

    @Column(nullable = false)
    private String createdTime;

    @Builder
    public Team(String name, String manager, String createdTime) {
        this.name = name;
        this.manager = manager;
        this.createdTime = createdTime;
    }
}
