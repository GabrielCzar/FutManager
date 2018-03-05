package br.ufc.quixada.npi.repositories;

import br.ufc.quixada.npi.beans.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;

@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team, Long>{
    Time findByName(String name);
}
