package br.ufc.quixada.npi.services;

import br.ufc.quixada.npi.beans.Player;
import br.ufc.quixada.npi.beans.Team;
import br.ufc.quixada.npi.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServices {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerServices playerServices;

    public Team saveTeam(String nome) {
        Team team = new Team(nome);
        teamRepository.save(team);
        return team;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void excluirTime(Long id) {
        teamRepository.delete(id);
    }

    public Team getTeamById(Long id) {
        return teamRepository.findOne(id);
    }

    public void addPlayerAoTime(Long idJog, Long idTime) {
        Team team = teamRepository.findOne(idTime);
        Player player = playerServices.getPlayer(idJog);
        player.setTeam(team);
        team.getPlayers().add(player);
        teamRepository.saveAndFlush(team);
    }
}
