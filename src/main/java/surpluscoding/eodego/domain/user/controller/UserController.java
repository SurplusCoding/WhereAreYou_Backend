package surpluscoding.eodego.domain.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import surpluscoding.eodego.domain.user.controller.dto.UserLoginRequestDto;
import surpluscoding.eodego.domain.user.controller.dto.UserRequestDto;
import surpluscoding.eodego.domain.user.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.findOne(userLoginRequestDto);
    }

    @PostMapping("/signup")
    public Long signUp(@RequestBody UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }
}
