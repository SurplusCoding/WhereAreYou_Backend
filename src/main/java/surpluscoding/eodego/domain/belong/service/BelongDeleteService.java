package surpluscoding.eodego.domain.belong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.repository.BelongRepository;

@Service
@RequiredArgsConstructor
public class BelongDeleteService {

    private final BelongRepository belongRepository;

    public void deleteByTeam(Long teamId) {
        belongRepository.deleteALLByTeamId(teamId);
    }

    public void deleteByUserId(Long userId) {
        belongRepository.deleteAllByUserId(userId);
    }
}
