package surpluscoding.eodego.domain.preset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surpluscoding.eodego.domain.preset.domain.Preset;

@Repository
public interface PresetRepository extends JpaRepository<Preset, Long> {
}
