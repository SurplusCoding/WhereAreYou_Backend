package surpluscoding.eodego.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.user.controller.dto.UserLoginRequestDto;
import surpluscoding.eodego.domain.user.controller.dto.UserRequestDto;
import surpluscoding.eodego.domain.user.domain.User;
import surpluscoding.eodego.domain.user.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String findOne(UserLoginRequestDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.email());

        if(user.isEmpty())
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");

        //System.out.println(user.get().getPassword());
        //System.out.println(passwordEncoder.encode(userDto.password()));

        //if(!user.get().getPassword().equals(passwordEncoder.encode(userDto.password())))
        //    throw new IllegalArgumentException("올바르지 않는 비밀번호입니다.");

        if (!passwordEncoder.matches(userDto.password(), user.get().getPassword()))
            throw new IllegalArgumentException("올바르지 않는 비밀번호입니다.");

        return "Success";
    }

    public Long save(UserRequestDto userRequestDto) {
        if(userRepository.findByEmail(userRequestDto.email())
                .isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        String password = passwordEncoder.encode(userRequestDto.password());
        System.out.println(password);
        return userRepository.save(userRequestDto.toEntity(password)).getId();
    }
}
