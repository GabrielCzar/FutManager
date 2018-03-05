package br.ufc.quixada.npi.beans;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Entity
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    @ManyToOne
    private Team team;

    public Player() {}

    public Player(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
