package surpluscoding.eodego.domain.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.service.BelongPostService;
import surpluscoding.eodego.domain.team.controller.dto.TeamCreateRequestDto;
import surpluscoding.eodego.domain.team.controller.dto.TeamJoinRequestDto;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.team.repository.TeamRepository;
import surpluscoding.eodego.domain.user.service.UserGetService;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final BelongPostService belongPostService;
    private final UserGetService userGetService;
    private final TeamRepository teamRepositroy;

    public Long addTeam(TeamCreateRequestDto requestDto) {
        String time = String.valueOf(new Date().getTime());
        String manager = userGetService.getUserName();

        Team team = teamRepositroy.save(requestDto.toEntity(time, manager));

        return belongPostService.addBelong(team).getTeam().getId();
    }

    public Long joinTeam(TeamJoinRequestDto requestDto) {
        Team team = teamRepositroy.findById(requestDto.teamId()).orElseThrow();

        return belongPostService.addBelong(team).getTeam().getId();
    }
}
