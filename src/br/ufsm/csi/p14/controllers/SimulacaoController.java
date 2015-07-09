package br.ufsm.csi.p14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by politecnico on 09/07/2015.
 */
@Controller
public class SimulacaoController {

    @RequestMapping(value = "inicia-simulacao.html")
    public String iniciaSimulacao() {
        return "inicia-simulacao";
    }

}
