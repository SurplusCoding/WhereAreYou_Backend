package surpluscoding.eodego.domain.status.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import surpluscoding.eodego.domain.status.service.StatusResponseDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/status")
public class StatusController {

    //private final StatusService statusService;

    //@GetMapping
    //public StatusResponseDto getStatus() {
    //    return statusService.get();
    //}
}
