package surpluscoding.eodego.domain.team.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private String createdDate;

    @Builder
    public Team(String name, String manager) {
        this.name = name;
        this.manager = manager;
        createdDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
