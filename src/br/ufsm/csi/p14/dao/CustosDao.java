package br.ufsm.csi.p14.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by politecnico on 07/07/2015.
 */
@Repository
public class CustosDao {

    @Autowired
    private SessionFactory sessionFactory;

}
