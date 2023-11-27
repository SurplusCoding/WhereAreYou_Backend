package surpluscoding.eodego.domain.belong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import surpluscoding.eodego.domain.team.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.user.controller.dto.UserResponseDto;
import surpluscoding.eodego.domain.belong.service.BelongService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/belong")
public class BelongController {

    private final BelongService belongService;

    @GetMapping("/{teamId}/user")
    public List<UserResponseDto> users(@PathVariable Long teamId) {
        return belongService.getUsers(teamId);
//        List<UserResponseDto> dto = belongService.getUsers(teamId);
//        return ResponseEntity.ok(dto);
    }

    @GetMapping("/team")
    public List<TeamResponseDto> teams() {
        return belongService.getTeams();
//        List<TeamResponseDto> dto = belongService.getTeams();
//        return ResponseEntity.ok(dto);
    }
}
