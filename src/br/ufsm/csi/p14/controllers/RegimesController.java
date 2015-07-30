package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.RegimeOperacionalDao;
import br.ufsm.csi.p14.model.RegimeOperacional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by politecnico on 30/07/2015.
 */
@Controller
public class RegimesController {

    @Autowired
    private RegimeOperacionalDao dao;

    @RequestMapping("listar-regimes.html")
    public String listarRegimes(Model model) {
        model.addAttribute("regimes", dao.findRegimesOperacionais());
        return "listar-regimes";
    }

    @RequestMapping(value = "editar-regime.html", method = RequestMethod.POST)
    public String editarRegime(@Valid RegimeOperacional regime, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editar-regime";
        }
        if (regime.getId() == null) {
            model.addAttribute("sucesso", "Regime Operacional criado com sucesso.");
        } else {
            model.addAttribute("sucesso", "Regime Operacional editado com sucesso.");
        }
        dao.save(regime);
        return "forward:listar-regimes.html";
    }

    @RequestMapping(value = "editar-regime.html", method = RequestMethod.GET)
    public String editarTarifa(Long id, Model model) {
        if (id != null) {
            model.addAttribute("regime", dao.getRegimeOperacionalById(id));
        } else {
            model.addAttribute("regime", new RegimeOperacional());
        }
        return "editar-regime";
    }

    @RequestMapping(value = "remover-regime.html", method = RequestMethod.GET)
    public String removeRegime(Long id, Model model) {
        RegimeOperacional regimeOperacional = dao.getRegimeOperacionalById(id);
        dao.removeRegime(regimeOperacional);
        model.addAttribute("sucesso", "Regime Operacional removido com sucesso.");
        return "forward:listar-regimes.html";
    }

}
