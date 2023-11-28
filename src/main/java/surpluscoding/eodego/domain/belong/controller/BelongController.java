package surpluscoding.eodego.domain.belong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surpluscoding.eodego.domain.belong.service.BelongPostService;
import surpluscoding.eodego.domain.team.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.user.controller.dto.UserResponseDto;
import surpluscoding.eodego.domain.belong.service.BelongService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/belong")
public class BelongController {

    private final BelongService belongService;
    private final BelongPostService belongPostService;

    @PostMapping("/{teamId}")
    public Long join(@PathVariable("teamId") Long teamId) {
        return belongPostService.createBelong(teamId);
    }

    @GetMapping("/{teamId}/user")
    public List<UserResponseDto> users(@PathVariable Long teamId) {
        return belongService.getUsers(teamId);
    }

    @GetMapping("/team")
    public List<TeamResponseDto> teams() {
        return belongService.getTeams();
    }

    @DeleteMapping("/{teamId}")
    public void exit(@PathVariable Long teamId) {
        belongService.deleteByTeamId(teamId);
    }
}
