/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.dao.custom.impl;

import lk.ijse.registration.dao.custom.QueryDAO;
import org.hibernate.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SSNLIVE
 */
@Component

public class QueryDAOImpl implements QueryDAO{

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void setEntityManager(EntityManager entityManager) {
//
//    }
}
