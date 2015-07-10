package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.RegimeOperacionalDao;
import br.ufsm.csi.p14.model.ValoresTarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by politecnico on 09/07/2015.
 */
@Controller
public class SimulacaoController {

    @Autowired
    private RegimeOperacionalDao dao;

    @RequestMapping(value = "inicia-simulacao.html")
    public String iniciaSimulacao(Model model) {
        model.addAttribute("regimes", dao.findRegimesOperacionais());
        model.addAttribute("tarifas", ValoresTarifa.NomesTarifas.values());
        return "inicia-simulacao";
    }

    @RequestMapping(value = "simulacao.ajax")
    public String simulacao(Long regime, String tarifa, Model model) {
        model.addAttribute("regime", regime);
        model.addAttribute("tarifa", tarifa);
        return "simulacao";
    }

}
