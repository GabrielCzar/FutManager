package br.ufc.quixada.npi.beans;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    List<Player> players;

    public Team() { }

    public Team(String name) {
        this.name = name;
    }
}
