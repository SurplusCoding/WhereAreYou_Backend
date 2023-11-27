package surpluscoding.eodego.domain.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import surpluscoding.eodego.domain.team.domain.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByIdIn(List<Long> id);
}
