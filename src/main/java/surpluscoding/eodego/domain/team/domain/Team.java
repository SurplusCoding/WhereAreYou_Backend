package surpluscoding.eodego.domain.team.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime createdTime;

    @Builder
    public Team(String name, String manager) {
        this.name = name;
        this.manager = manager;
        createdTime = LocalDateTime.now();
    }
}
