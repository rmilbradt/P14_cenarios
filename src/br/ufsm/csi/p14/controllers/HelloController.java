package br.ufsm.csi.p14.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by politecnico on 26/05/2015.
 */
@Controller
public class HelloController {

    @RequestMapping("hello.html")
    public String hello() {
        return "hello";
    }

}
