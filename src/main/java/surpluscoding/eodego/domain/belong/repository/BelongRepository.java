package surpluscoding.eodego.domain.belong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import surpluscoding.eodego.domain.belong.domain.Belong;

public interface BelongRepository extends JpaRepository<Belong, Long> {
}
