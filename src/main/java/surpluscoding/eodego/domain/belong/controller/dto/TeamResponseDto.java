package surpluscoding.eodego.domain.belong.controller.dto;

import java.time.LocalDateTime;

public record TeamResponseDto(
        Long id,
        String name,
        String manager,
        LocalDateTime createdTime
) { }
