package br.ufsm.csi.p14.dao;

import br.ufsm.csi.p14.model.ValoresTarifa;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by politecnico on 07/07/2015.
 */
@Repository
public class CustosDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Collection<ValoresTarifa> findTarifas() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ValoresTarifa.class);
        criteria.addOrder(Order.asc("nomeTarifa")).addOrder(Order.asc("tipoCusto"));
        Collection<ValoresTarifa> tarifas = criteria.list();
        if (tarifas != null && !tarifas.isEmpty()) {
            return tarifas;
        } else {
            return criaTodasTarifas();
        }
    }

    private Collection<ValoresTarifa> criaTodasTarifas() {
        ArrayList<ValoresTarifa> ret = new ArrayList<>();

        //VERDE - NA
        ValoresTarifa valoresTarifa = new ValoresTarifa();
        valoresTarifa.setNomeTarifa(ValoresTarifa.NomesTarifas.VERDE.name());
        valoresTarifa.setTipoCusto(ValoresTarifa.TiposCusto.NA.name());
        valoresTarifa.setDemanda(8.92f);
        valoresTarifa.setEnergiaBandVerde(0f);
        valoresTarifa.setEnergiaBandAmarela(0f);
        valoresTarifa.setEnergiaBandVermelha(0f);
        save(valoresTarifa);
        ret.add(valoresTarifa);

        //VERDE - PONTA
        valoresTarifa = new ValoresTarifa();
        valoresTarifa.setNomeTarifa(ValoresTarifa.NomesTarifas.VERDE.name());
        valoresTarifa.setTipoCusto(ValoresTarifa.TiposCusto.PONTA.name());
        valoresTarifa.setDemanda(0f);
        valoresTarifa.setEnergiaBandVerde(1.05509f);
        valoresTarifa.setEnergiaBandAmarela(1.08009f);
        valoresTarifa.setEnergiaBandVermelha(1.11009f);
        save(valoresTarifa);
        ret.add(valoresTarifa);

        //VERDE - FORA PONTA
        valoresTarifa = new ValoresTarifa();
        valoresTarifa.setNomeTarifa(ValoresTarifa.NomesTarifas.VERDE.name());
        valoresTarifa.setTipoCusto(ValoresTarifa.TiposCusto.FORA_PONTA.name());
        valoresTarifa.setDemanda(0f);
        valoresTarifa.setEnergiaBandVerde(0.30775f);
        valoresTarifa.setEnergiaBandAmarela(0.33275f);
        valoresTarifa.setEnergiaBandVermelha(0.36275f);
        save(valoresTarifa);
        ret.add(valoresTarifa);

        //AZUL - PONTA
        valoresTarifa = new ValoresTarifa();
        valoresTarifa.setNomeTarifa(ValoresTarifa.NomesTarifas.AZUL.name());
        valoresTarifa.setTipoCusto(ValoresTarifa.TiposCusto.PONTA.name());
        valoresTarifa.setDemanda(24.31f);
        valoresTarifa.setEnergiaBandVerde(0.45884f);
        valoresTarifa.setEnergiaBandAmarela(0.48384f);
        valoresTarifa.setEnergiaBandVermelha(0.51384f);
        save(valoresTarifa);
        ret.add(valoresTarifa);

        //AZUL - FORA PONTA
        valoresTarifa = new ValoresTarifa();
        valoresTarifa.setNomeTarifa(ValoresTarifa.NomesTarifas.AZUL.name());
        valoresTarifa.setTipoCusto(ValoresTarifa.TiposCusto.FORA_PONTA.name());
        valoresTarifa.setDemanda(8.92f);
        valoresTarifa.setEnergiaBandVerde(0.30775f);
        valoresTarifa.setEnergiaBandAmarela(0.33275f);
        valoresTarifa.setEnergiaBandVermelha(0.36275f);
        save(valoresTarifa);
        ret.add(valoresTarifa);

        //CONVENCIONAL
        valoresTarifa = new ValoresTarifa();
        valoresTarifa.setNomeTarifa(ValoresTarifa.NomesTarifas.CONVENCIONAL.name());
        valoresTarifa.setTipoCusto(null);
        valoresTarifa.setDemanda(26.42f);
        valoresTarifa.setEnergiaBandVerde(0.32035f);
        valoresTarifa.setEnergiaBandAmarela(0.34535f);
        valoresTarifa.setEnergiaBandVermelha(0.37535f);
        save(valoresTarifa);
        ret.add(valoresTarifa);

        return ret;
    }

    public void save(ValoresTarifa valoresTarifa) {
        sessionFactory.getCurrentSession().saveOrUpdate(valoresTarifa);
    }
}
