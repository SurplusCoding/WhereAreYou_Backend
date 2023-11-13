package surpluscoding.eodego.domain.belong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.domain.Belong;
import surpluscoding.eodego.domain.belong.repository.BelongRepository;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.user.domain.User;
import surpluscoding.eodego.domain.user.service.UserGetService;

@Service
@RequiredArgsConstructor
public class BelongPostService {

    private final BelongRepository belongRepository;
    private final UserGetService userGetService;

    public Belong addBelong(Team team) {
        User user = userGetService.getUser();
        return belongRepository.save(new Belong(user, team));
    }
}
