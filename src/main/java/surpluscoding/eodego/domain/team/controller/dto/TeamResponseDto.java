package surpluscoding.eodego.domain.team.controller.dto;

import java.time.LocalDateTime;

public record TeamResponseDto(
        Long id,
        String name,
        String manager,
        LocalDateTime createdTime
) { }
