package surpluscoding.eodego.domain.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.service.BelongDeleteService;
import surpluscoding.eodego.domain.belong.service.BelongPostService;
import surpluscoding.eodego.domain.team.controller.dto.TeamCreateRequestDto;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.team.repository.TeamRepository;
import surpluscoding.eodego.domain.user.service.UserGetService;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final BelongPostService belongPostService;
    private final BelongDeleteService belongDeleteService;
    private final UserGetService userGetService;
    private final TeamRepository teamRepository;

    public Long createTeam(TeamCreateRequestDto requestDto) {
        String manager = userGetService.getUserName();
        Team team = teamRepository.save(requestDto.toEntity(manager));

        return belongPostService.createBelong(team).getTeam().getId();
    }

    public void deleteTeam(Long teamId) {
        belongDeleteService.deleteByTeam(teamId);
        teamRepository.deleteById(teamId);
    }
}
