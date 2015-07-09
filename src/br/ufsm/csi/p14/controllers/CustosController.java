package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.CustosDao;
import br.ufsm.csi.p14.model.Custos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by politecnico on 09/07/2015.
 */
@Controller
public class CustosController {

    @Autowired
    private CustosDao dao;

    @RequestMapping(value = "editar-custos.html", method = RequestMethod.POST)
    public String editarCustos(Custos custos, Model model) {
        dao.save(custos);
        model.addAttribute("sucesso", "Custos editados com sucesso.");
        return "editar-custos";
    }

    @RequestMapping(value = "editar-custos.html", method = RequestMethod.GET)
    public String visualizarCustos(Model model) {
        model.addAttribute("custos", dao.getCustos());
        return "editar-custos";
    }

}
