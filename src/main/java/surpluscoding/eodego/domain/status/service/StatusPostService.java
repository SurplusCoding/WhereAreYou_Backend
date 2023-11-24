package surpluscoding.eodego.domain.status.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.status.repository.StatusRepository;

@Service
@RequiredArgsConstructor
public class StatusPostService {

    private final StatusRepository statusRepository;

//    public void execute() {
//        statusRepository.save()
//    }
}
