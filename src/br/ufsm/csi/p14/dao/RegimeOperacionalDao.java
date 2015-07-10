package br.ufsm.csi.p14.dao;

import br.ufsm.csi.p14.model.RegimeOperacional;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by politecnico on 10/07/2015.
 */
@Repository
public class RegimeOperacionalDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProdutoresDao produtoresDao;

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
        regimeOperacional.setNumProdutores(produtoresDao.getNumProdutores());
        save(regimeOperacional);
        regimes.add(regimeOperacional);

        regimeOperacional = new RegimeOperacional();
        regimeOperacional.setNome("21 horas - 160kW");
        regimeOperacional.setQtdHoras(21);
        regimeOperacional.setPotencia(160f);
        regimeOperacional.setNumProdutores(produtoresDao.getNumProdutores());
        save(regimeOperacional);
        regimes.add(regimeOperacional);

        regimeOperacional = new RegimeOperacional();
        regimeOperacional.setNome("7 horas - 480kW");
        regimeOperacional.setQtdHoras(7);
        regimeOperacional.setPotencia(480f);
        regimeOperacional.setNumProdutores(produtoresDao.getNumProdutores());
        save(regimeOperacional);
        regimes.add(regimeOperacional);

        return regimes;
    }

    @Transactional
    public void save(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

}
