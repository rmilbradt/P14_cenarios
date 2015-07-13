package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.ProdutoresDao;
import br.ufsm.csi.p14.dao.RegimeOperacionalDao;
import br.ufsm.csi.p14.model.Custos;
import br.ufsm.csi.p14.model.Produtor;
import br.ufsm.csi.p14.model.RegimeOperacional;
import br.ufsm.csi.p14.model.ValoresTarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by politecnico on 09/07/2015.
 */
@Controller
public class SimulacaoController {

    @Autowired
    private RegimeOperacionalDao dao;

    @Autowired
    private ProdutoresDao produtoresDao;

    @RequestMapping(value = "inicia-simulacao.html")
    public String iniciaSimulacao(Model model) {
        model.addAttribute("regimes", dao.findRegimesOperacionais());
        model.addAttribute("tarifas", ValoresTarifa.NomesTarifas.values());
        model.addAttribute("bandeiras", Custos.BandeiraTarifaria.values());
        return "inicia-simulacao";
    }

    @RequestMapping(value = "simulacao.ajax")
    public String simulacao(Long regime, String tarifa, String bandeira, Model model) {
        model.addAttribute("tarifa", tarifa);
        model.addAttribute("bandeira", bandeira);
        RegimeOperacional regimeOperacional = dao.getRegimeOperacional(regime, tarifa);
        model.addAttribute("regimeOperacional", regimeOperacional);
        Collection<Produtor> produtores = produtoresDao.findProdutores();
        for (Produtor produtor : produtores) {
            produtor.setRegime(regimeOperacional);
            produtor.setBandeiraTarifaria(Custos.BandeiraTarifaria.valueOf(bandeira));
        }
        model.addAttribute("produtores", produtores);
        model.addAttribute("custoAbaixo500", regimeOperacional.getCustos().getCustoKWhPrimeiros500(Custos.BandeiraTarifaria.valueOf(bandeira)));
        model.addAttribute("custoAcima500", regimeOperacional.getCustos().getCustoKWhAcima500(Custos.BandeiraTarifaria.valueOf(bandeira)));
        return "simulacao";
    }

}
