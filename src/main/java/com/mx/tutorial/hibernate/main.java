/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.tutorial.hibernate;

import com.mx.tutorial.hibernate.entities.Medico;
import com.mx.tutorial.hibernate.sessions.HibernateSession;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author cesar.huerta
 */
public class main {

    public static void main(String[] args) {

        Session session = null;
        Medico medico = null;
        List<Medico> medicos = null;

        try {

            session = HibernateSession.getSessionFactory().openSession();
            Criteria cri = session.createCriteria(Medico.class);
            
            
            Criterion id = Restrictions.eq("id", 1);
            Criterion nombre = Restrictions.eq("nombre", 1);
            
            LogicalExpression le = Restrictions.and(id, nombre);
            
            cri.add(le);
            medico = (Medico) cri.uniqueResult();

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (session == null) {
                session.close();

            }
        }
        System.out.println(medico);
    }

}
