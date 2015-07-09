package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.CustosDao;
import br.ufsm.csi.p14.model.ValoresTarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

    @RequestMapping(value = "editar-tarifa.html", method = RequestMethod.POST)
    public String editarTarifa(@Valid ValoresTarifa tarifa, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editar-tarifa";
        }
        dao.save(tarifa);
        model.addAttribute("sucesso", "Tarifa editada com sucesso.");
        return "forward:listar-tarifas.html";
    }

    @RequestMapping(value = "editar-tarifa.html", method = RequestMethod.GET)
    public String editarTarifa(Long id, Model model) {
        model.addAttribute("tarifa", dao.findTarifaById(id));
        return "editar-tarifa";
    }

}
