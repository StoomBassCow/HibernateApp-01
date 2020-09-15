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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

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
            SQLQuery query = (SQLQuery) session.createNativeQuery("SELECT id, nombre FROM medico")
                    .addScalar("id", new IntegerType())
                    .addScalar("nombre", new StringType())
                    .setResultTransformer(Transformers.aliasToBean(Medico.class));
            
            medicos = query.list();
                    
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (session == null) {
                session.close();

            }
        }
        System.out.println(medicos);
    }

}
