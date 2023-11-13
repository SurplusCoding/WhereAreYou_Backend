package surpluscoding.eodego.domain.team.controller.dto;

import surpluscoding.eodego.domain.team.domain.Team;

public record TeamCreateRequestDto (
        String name,
        String manager,
        String createdTime
) {

    public Team toEntity(String createdTime, String manager) {
        return Team.builder()
                .name(name)
                .manager(manager)
                .createdTime(createdTime)
                .build();
    }
}
