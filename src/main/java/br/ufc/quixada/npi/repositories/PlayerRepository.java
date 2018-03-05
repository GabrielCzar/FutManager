package br.ufc.quixada.npi.repositories;

import br.ufc.quixada.npi.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByTeamIsNull();
}
