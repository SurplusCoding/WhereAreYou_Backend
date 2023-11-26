package surpluscoding.eodego.domain.team.controller.dto;

import surpluscoding.eodego.domain.team.domain.Team;

public record TeamCreateRequestDto (
        String name
) {

    public Team toEntity(String manager) {
        return Team.builder()
                .name(name)
                .manager(manager)
                .build();
    }
}
