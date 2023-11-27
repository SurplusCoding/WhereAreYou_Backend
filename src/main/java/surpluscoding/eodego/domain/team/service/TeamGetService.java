package surpluscoding.eodego.domain.team.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import surpluscoding.eodego.domain.team.controller.dto.TeamResponseDto;
import surpluscoding.eodego.domain.team.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamGetService {

    private final TeamRepository teamRepository;

    public List<TeamResponseDto> getTeams(List<Long> teamIds) {
//        List<TeamResponseDto> dto = new ArrayList<>();
//        for(Long id : teamIds) {
//            dto.add(new TeamResponseDto(teamRepository.findById(id).orElseThrow()));
//        }
        return teamRepository.findAllByIdIn(teamIds).stream().map(TeamResponseDto::new).toList();
    }
}
