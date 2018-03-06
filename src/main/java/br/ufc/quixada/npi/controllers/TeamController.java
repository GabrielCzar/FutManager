package br.ufc.quixada.npi.controllers;

import br.ufc.quixada.npi.beans.Team;
import br.ufc.quixada.npi.services.PlayerServices;
import br.ufc.quixada.npi.services.TeamServices;
import br.ufc.quixada.npi.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(Constants.TEAMS)
public class TeamController {

    @Autowired
    private TeamServices teamServices;

    @Autowired
    private PlayerServices playerServices;

    @GetMapping
    ModelAndView index(ModelAndView model) {
        model.setViewName(Constants.TEAMS);
        model.addObject("times", teamServices.getAllTeams());
        return model;
    }

    @GetMapping("/{id}")
    ModelAndView details(ModelAndView model, @PathVariable Long id, @RequestParam(required=false) String erro) {
        model.setViewName(Constants.DETAILS);
        model.addObject("time", teamServices.getTeamById(id));
        model.addObject("jogadoresSemTime", playerServices.getAllWithoutTeam());

        model.addObject("erro", erro);

        return model;
    }

    @PostMapping("/salvar")
    ModelAndView save(@RequestParam String time) {
        teamServices.saveTeam(time);
        return new ModelAndView("redirect:/" + Constants.TEAMS);
    }

    @GetMapping("/excluir/{id}")
    ModelAndView del(@PathVariable Long id) {
        teamServices.excluirTime(id);
        return new ModelAndView("redirect:/" + Constants.TEAMS);
    }

    @PostMapping("/{id}/add-jogador")
    public ModelAndView addPlayer(@PathVariable Long id, @RequestParam Long idJog, ModelAndView model) {
        boolean itsOk = teamServices.addPlayerAoTime(idJog, id);
        if(!itsOk){
            String err = "O time já está completo.";
            model.addObject("erro", err);
        }
        model.setViewName("redirect:/times/" + id);
        return model;
    }
}
