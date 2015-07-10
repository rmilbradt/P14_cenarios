package br.ufsm.csi.p14.dao;

import br.ufsm.csi.p14.model.Produtor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by politecnico on 07/07/2015.
 */
@Repository
public class ProdutoresDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Collection<Produtor> findProdutores() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Produtor.class);
        criteria.addOrder(Order.asc("nome"));
        return criteria.list();
    }

    @Transactional
    public Produtor findProdutorByCodigoUC(Long codigoUC) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Produtor.class);
        criteria.add(Restrictions.eq("codigoUC", codigoUC));
        return (Produtor) criteria.uniqueResult();
    }

    @Transactional
    public void save(Produtor produtor) {
        sessionFactory.getCurrentSession().saveOrUpdate(produtor);
    }

    @Transactional
    public Integer getNumProdutores() {
        return ((Number) sessionFactory.getCurrentSession().createCriteria(Produtor.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
    }
}
