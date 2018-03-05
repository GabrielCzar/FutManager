package br.ufc.quixada.npi.controllers;

import br.ufc.quixada.npi.AutoEstudoApplication;
import br.ufc.quixada.npi.beans.Player;
import br.ufc.quixada.npi.services.PlayerServices;
import br.ufc.quixada.npi.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(Constants.PLAYERS)
public class PlayerController {

    @Autowired
    private PlayerServices playerServices;

    @GetMapping
    ModelAndView index(ModelAndView model) {
        model.setViewName(Constants.PLAYERS);
        List<Player> all = playerServices.getAll();
        model.addObject("jogadores", all);
        return model;
    }

    @PostMapping("/salvar")
    ModelAndView save(@RequestParam String nome, @RequestParam Integer idade) {
        playerServices.save(nome, idade);
        return new ModelAndView("redirect:/" + Constants.PLAYERS);
    }
}
