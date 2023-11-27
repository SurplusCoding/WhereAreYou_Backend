package surpluscoding.eodego.domain.belong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import surpluscoding.eodego.domain.belong.domain.Belong;

import java.util.List;

@Repository
public interface BelongRepository extends JpaRepository<Belong, Long> {

    List<Belong> findAllByTeamId(Long teamId);

    List<Belong> findAllByUserId(Long userId);

    void deleteByTeamId(Long teamId);
}
