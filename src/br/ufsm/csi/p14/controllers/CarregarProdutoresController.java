package br.ufsm.csi.p14.controllers;

import br.ufsm.csi.p14.dao.ProdutoresDao;
import br.ufsm.csi.p14.model.Produtor;
import br.ufsm.csi.p14.util.LeitorCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by politecnico on 07/07/2015.
 */
@Controller
public class CarregarProdutoresController {

    @Autowired
    private ProdutoresDao dao;

    @RequestMapping(value = "carregar-produtores.html", method = RequestMethod.POST)
    public String carregarProdutores(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file != null && !file.isEmpty()) {
            LeitorCSV leitor = new LeitorCSV(file.getInputStream());
            String[] linha;
            while ((linha = leitor.nextLine()) != null) {
                try {
                    Long codigoUC = new Long(linha[1]);
                    Produtor produtor = dao.findProdutorByCodigoUC(codigoUC);
                    if (produtor == null) {
                        produtor = new Produtor();
                        produtor.setCodigoUC(codigoUC);
                    }
                    produtor.setNome(linha[0]);
                    produtor.setTensaoNominal(linha[2]);
                    produtor.setGrupoTensao(linha[3]);
                    produtor.setClassificacao(linha[4]);
                    produtor.setConsumoMinimo(Float.parseFloat(linha[5]));
                    produtor.setConsumo(Float.parseFloat(linha[6]));
                    dao.save(produtor);
                } catch (Exception e) { }
            }
            model.addAttribute("sucesso", "Produtores carregados.");
        }
        model.addAttribute("produtores", dao.findProdutores());
        return "carregar-produtores";
    }

    @RequestMapping(value = "carregar-produtores.html", method = RequestMethod.GET)
    public String listarProdutores(Model model) throws IOException {
        model.addAttribute("produtores", dao.findProdutores());
        return "carregar-produtores";
    }

}
