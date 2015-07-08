package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.CustosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by politecnico on 08/07/2015.
 */
@Controller
public class TarifasController {

    @Autowired
    private CustosDao dao;

    @RequestMapping("listar-tarifas.html")
    public String listarTarifas(Model model) {
        model.addAttribute("tarifas", dao.findTarifas());
        return "listar-tarifas";
    }

}
