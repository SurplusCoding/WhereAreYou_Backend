package surpluscoding.eodego.domain.preset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import surpluscoding.eodego.domain.preset.domain.Preset;

public interface PresetRepository extends JpaRepository<Preset, Long> {
}
