package br.ufc.quixada.npi.services;

import br.ufc.quixada.npi.beans.Player;
import br.ufc.quixada.npi.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServices {

    @Autowired
    private PlayerRepository playerRepository;

    public Player save(String nome, Integer idade) {
        Player player = new Player(nome, idade);
        playerRepository.save(player);
        return player;
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public List<Player> getAllWithoutTeam() {
        return playerRepository.findAllByTeamIsNull();
    }

    public Player getPlayer(Long idJog) {
        return playerRepository.getOne(idJog);
    }

    public void save(Player player) {
        playerRepository.save(player);
    }
}
