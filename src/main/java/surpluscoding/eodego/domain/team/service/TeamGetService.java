package surpluscoding.eodego.domain.team.service;

import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.belong.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.team.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamGetService {

    private final TeamRepository teamRepository;

    public List<TeamResponseDto> getTeams(List<Long> teamIds) {
        List<TeamResponseDto> dto = new ArrayList<>();
        for(Long id : teamIds) {
            dto.add(new TeamResponseDto(teamRepository.findById(id).orElseThrow()));
        }
        return dto;
    }
}
