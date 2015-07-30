package br.ufsm.csi.p14.dao;

import br.ufsm.csi.p14.model.RegimeOperacional;
import br.ufsm.csi.p14.model.ValoresTarifa;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by politecnico on 10/07/2015.
 */
@Repository
public class RegimeOperacionalDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProdutoresDao produtoresDao;

    @Autowired
    private CustosDao custosDao;

    @Transactional
    public Collection<RegimeOperacional> findRegimesOperacionais() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RegimeOperacional.class);
        criteria.addOrder(Order.asc("id"));
        Collection<RegimeOperacional> regimes = criteria.list();
        if (regimes == null || regimes.isEmpty()) {
            regimes = criaRegimesOperacionais();
        }
        return regimes;
    }

    private Collection<RegimeOperacional> criaRegimesOperacionais() {
        Collection<RegimeOperacional> regimes = new ArrayList<>();

        RegimeOperacional regimeOperacional = new RegimeOperacional();
        regimeOperacional.setNome("24 horas - 140kW");
        regimeOperacional.setQtdHoras(24);
        regimeOperacional.setPotencia(140f);
        regimeOperacional.setCustoInvestimento(500000f);
        regimeOperacional.setCustoRH(8000f);
        regimeOperacional.setNumProdutores(produtoresDao.getNumProdutores());
        save(regimeOperacional);
        regimes.add(regimeOperacional);

        regimeOperacional = new RegimeOperacional();
        regimeOperacional.setNome("21 horas - 160kW");
        regimeOperacional.setQtdHoras(21);
        regimeOperacional.setPotencia(160f);
        regimeOperacional.setCustoInvestimento(500000f);
        regimeOperacional.setCustoRH(8000f);
        regimeOperacional.setNumProdutores(produtoresDao.getNumProdutores());
        save(regimeOperacional);
        regimes.add(regimeOperacional);

        regimeOperacional = new RegimeOperacional();
        regimeOperacional.setNome("7 horas - 480kW");
        regimeOperacional.setQtdHoras(7);
        regimeOperacional.setPotencia(480f);
        regimeOperacional.setCustoInvestimento(500000f);
        regimeOperacional.setCustoRH(8000f);
        regimeOperacional.setNumProdutores(produtoresDao.getNumProdutores());
        save(regimeOperacional);
        regimes.add(regimeOperacional);

        return regimes;
    }

    @Transactional
    public void save(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    @Transactional
    public RegimeOperacional getRegimeOperacionalById(Long id) {
        return (RegimeOperacional) sessionFactory.getCurrentSession().get(RegimeOperacional.class, id);
    }

    @Transactional
    public RegimeOperacional getRegimeOperacional(Long regime, String tarifa) {
        RegimeOperacional reg = (RegimeOperacional) sessionFactory.getCurrentSession().get(RegimeOperacional.class, regime);
        reg.setNumProdutores(produtoresDao.getNumProdutores());
        reg.setNomeTarifa(ValoresTarifa.NomesTarifas.valueOf(tarifa));
        reg.setCustos(custosDao.getCustos());
        Map<ValoresTarifa.NomesTarifas, Map<ValoresTarifa.TiposCusto, ValoresTarifa>> map = new HashMap<>();
        for (ValoresTarifa valores : custosDao.findTarifas()) {
            Map<ValoresTarifa.TiposCusto, ValoresTarifa> m = map.get(ValoresTarifa.NomesTarifas.valueOf(valores.getNomeTarifa()));
            valores.setCustos(reg.getCustos());
            if (m == null) {
                m = new HashMap<>();
                map.put(ValoresTarifa.NomesTarifas.valueOf(valores.getNomeTarifa()), m);
            }
            if (valores.getTipoCusto() == null) {
                valores.setTipoCusto(ValoresTarifa.TiposCusto.NA.name());
            }
            m.put(ValoresTarifa.TiposCusto.valueOf(valores.getTipoCusto()), valores);
        }
        reg.setValoresTarifa(map);
        return reg;
    }

    @Transactional
    public void removeRegime(RegimeOperacional regimeOperacional) {
        sessionFactory.getCurrentSession().delete(regimeOperacional);
    }
}
