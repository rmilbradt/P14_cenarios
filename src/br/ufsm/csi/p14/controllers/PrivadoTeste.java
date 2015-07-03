package br.ufsm.csi.p14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by politecnico on 29/05/2015.
 */
@Controller
public class PrivadoTeste {

    @RequestMapping("privado.priv")
    public String privado() {
        return "privado";
    }

}
