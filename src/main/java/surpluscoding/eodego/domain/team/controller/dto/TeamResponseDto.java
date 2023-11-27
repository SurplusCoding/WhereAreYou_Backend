package surpluscoding.eodego.domain.team.controller.dto;

import surpluscoding.eodego.domain.team.domain.Team;

public record TeamResponseDto(
        Long id,
        String name,
        String manager,
        String createdDate
) {
    public TeamResponseDto(Team team) {
        this(
                team.getId(),
                team.getName(),
                team.getManager(),
                team.getCreatedDate()
        );
    }
}
