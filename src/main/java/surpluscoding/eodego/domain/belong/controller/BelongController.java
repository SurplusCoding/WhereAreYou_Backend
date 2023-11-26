package surpluscoding.eodego.domain.belong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import surpluscoding.eodego.domain.belong.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.user.controller.dto.UserResponseDto;
import surpluscoding.eodego.domain.belong.service.BelongService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/belong")
public class BelongController {

    private final BelongService belongService;

    @GetMapping("/{teamId}/user")
    public List<UserResponseDto> users(@PathVariable Long teamId) {
        return belongService.getUsers(teamId);
    }

    @GetMapping("/team")
    public List<TeamResponseDto> teams() {
        return belongService.getTeams();
    }
}
