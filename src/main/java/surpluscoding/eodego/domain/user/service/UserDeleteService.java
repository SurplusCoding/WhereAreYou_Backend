package surpluscoding.eodego.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.service.BelongDeleteService;
import surpluscoding.eodego.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

    private final UserGetService userGetService;
    private final BelongDeleteService belongDeleteService;
    private final UserRepository userRepository;

    public void deleteUser() {
        Long userId = userGetService.getUserId();
        belongDeleteService.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }
}
