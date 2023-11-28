package surpluscoding.eodego.domain.team.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surpluscoding.eodego.domain.team.controller.dto.TeamCreateRequestDto;
import surpluscoding.eodego.domain.team.service.TeamService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public Long create(@RequestBody TeamCreateRequestDto requestDto) {
        return teamService.createTeam(requestDto);
    }

    @DeleteMapping("/{teamId}")
    public void delete(@PathVariable("teamId") Long teamId) {
        teamService.deleteTeam(teamId);
    }
}
