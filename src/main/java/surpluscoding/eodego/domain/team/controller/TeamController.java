package surpluscoding.eodego.domain.team.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import surpluscoding.eodego.domain.team.controller.dto.TeamCreateRequestDto;
import surpluscoding.eodego.domain.team.controller.dto.TeamJoinRequestDto;
import surpluscoding.eodego.domain.team.service.TeamService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("create")
    public Long create(@RequestBody TeamCreateRequestDto requestDto) {
        return teamService.addTeam(requestDto);
    }

    @PostMapping("join")
    public Long join(@RequestBody TeamJoinRequestDto requestDto) {
        return teamService.joinTeam(requestDto);
    }
}
