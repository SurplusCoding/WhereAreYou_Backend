package surpluscoding.eodego.domain.team.controller.dto;

import org.springframework.format.annotation.DateTimeFormat;
import surpluscoding.eodego.domain.team.domain.Team;

public record TeamCreateRequestDto (
        String name
) {

    public Team toEntity(String createdTime, String manager) {
        return Team.builder()
                .name(name)
                .manager(manager)
                .build();
    }
}
