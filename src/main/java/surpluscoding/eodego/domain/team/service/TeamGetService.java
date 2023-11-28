package surpluscoding.eodego.domain.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.team.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.team.domain.Team;
import surpluscoding.eodego.domain.team.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamGetService {

    private final TeamRepository teamRepository;

    public List<TeamResponseDto> getTeams(List<Long> teamIds) {
        return teamRepository.findAllByIdIn(teamIds).stream().map(TeamResponseDto::new).toList();
    }

    public Team getTeam(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow();
    }
}
