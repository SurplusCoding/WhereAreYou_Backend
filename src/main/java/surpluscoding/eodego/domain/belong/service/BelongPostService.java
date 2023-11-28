package surpluscoding.eodego.domain.belong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.domain.Belong;
import surpluscoding.eodego.domain.belong.repository.BelongRepository;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.team.service.TeamGetService;
import surpluscoding.eodego.domain.user.domain.User;
import surpluscoding.eodego.domain.user.service.UserGetService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BelongPostService {

    private final BelongRepository belongRepository;
    private final UserGetService userGetService;
    private final TeamGetService teamGetService;

    public Belong createBelong(Team team) {
        User user = userGetService.getUser();
        return belongRepository.save(new Belong(user, team));
    }

    public Long createBelong(Long teamId) {
        Team team = teamGetService.getTeam(teamId);
        User user = userGetService.getUser();

        Optional<Belong> belongs = belongRepository.findByUserAndTeam(user, team);
        if(belongs.isPresent())
            throw new RuntimeException("이미 가입된 팀입니다.");

        return belongRepository.save(new Belong(user, team)).getId();
    }
}
