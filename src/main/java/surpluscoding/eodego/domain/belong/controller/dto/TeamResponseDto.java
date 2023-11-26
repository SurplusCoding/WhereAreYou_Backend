package surpluscoding.eodego.domain.belong.controller.dto;

import surpluscoding.eodego.domain.team.domain.Team;

import java.time.LocalDateTime;

public record TeamResponseDto(
        Long id,
        String name,
        String manager,
        LocalDateTime createdTime
) {
    public TeamResponseDto(Team team) {
        this(
                team.getId(),
                team.getName(),
                team.getManager(),
                team.getCreatedTime()
        );
    }
}
