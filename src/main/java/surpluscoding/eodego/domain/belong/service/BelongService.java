package surpluscoding.eodego.domain.belong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.belong.domain.Belong;
import surpluscoding.eodego.domain.belong.repository.BelongRepository;
import surpluscoding.eodego.domain.team.service.TeamGetService;
import surpluscoding.eodego.domain.user.controller.dto.UserResponseDto;
import surpluscoding.eodego.domain.user.service.UserGetService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BelongService {

    private final BelongRepository belongRepository;
    private final UserGetService userGetService;
    private final TeamGetService teamGetService;

    public List<UserResponseDto> getUsers(Long teamId) {
        List<Belong> belongs = belongRepository.findAllByTeamId(teamId).stream().toList();

        List<Long> userIds = new ArrayList<>();
        for (Belong belong: belongs) {
            userIds.add(belong.getUser().getId());
        }

        return userGetService.getUsers(userIds);
    }

    public List<TeamResponseDto> getTeams() {
        Long userId = userGetService.getUserId();
        List<Belong> belongs = belongRepository.findAllByUserId(userId).stream().toList();

        List<Long> teamIds = new ArrayList<>();
        for (Belong belong : belongs) {
            teamIds.add(belong.getTeam().getId());
        }

        return teamGetService.getTeams(teamIds);
    }
}
