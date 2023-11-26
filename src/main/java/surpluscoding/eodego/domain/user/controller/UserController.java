package surpluscoding.eodego.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import surpluscoding.eodego.domain.preset.controller.dto.StatusRequestDto;
import surpluscoding.eodego.domain.user.controller.dto.*;
import surpluscoding.eodego.domain.user.service.UserGetService;
import surpluscoding.eodego.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserGetService userGetService;

    @PostMapping("/signup")
    public Long signup(@RequestBody UserRequestDto userRequestDto) {
        return userService.addUser(userRequestDto);
    }

    @PostMapping("/login")
    public ResponseTokenDto login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }

    @GetMapping
    public UserResponseDto readUser() {
        return userGetService.get();
    }

    @PutMapping("/status")
    public UserResponseDto updateStatus(@RequestBody StatusRequestDto requestDto) {
        return userService.setStatus(requestDto);
    }

}
