package surpluscoding.eodego.domain.belong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import surpluscoding.eodego.domain.belong.domain.Belong;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface BelongRepository extends JpaRepository<Belong, Long> {

    List<Belong> findAllByTeamId(Long teamId);

    List<Belong> findAllByUserId(Long userId);

    @Transactional
    void deleteByTeamIdAndUserId(Long teamId, Long userId);

    @Transactional
    void deleteALLByTeamId(Long teamId);

    @Transactional
    void deleteAllByUserId(Long userId);

    Optional<Belong> findByUserAndTeam(User user, Team team);
}
