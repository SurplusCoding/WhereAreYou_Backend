package surpluscoding.eodego.domain.status.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surpluscoding.eodego.domain.status.domain.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
