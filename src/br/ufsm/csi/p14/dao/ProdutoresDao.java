package br.ufsm.csi.p14.dao;

import br.ufsm.csi.p14.model.Produtor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
        criteria.addOrder(Order.asc("nomePropriedade")).addOrder(Order.asc("nome"));
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
        Query q = sessionFactory.getCurrentSession().createQuery("select count(distinct p.nomePropriedade) from br.ufsm.csi.p14.model.Produtor p");
        return ((Number) q.uniqueResult()).intValue();
    }

    public void removeNotIn(Collection<Long> codigos) {
        Query q = sessionFactory.getCurrentSession().createQuery("delete from br.ufsm.csi.p14.model.Produtor prod where prod.codigoUC not in (:cods)");
        q.setParameterList("cods", codigos);
        q.executeUpdate();
    }
}
