package surpluscoding.eodego.domain.status.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import surpluscoding.eodego.domain.preset.domain.Preset;

@Entity
@Getter
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Preset preset;

    @Column(nullable = false)
    private String djel;

    @Column(nullable = false)
    private String howLong;

    @Column(nullable = false)
    private String what;
}
