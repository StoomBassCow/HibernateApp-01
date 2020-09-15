/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.tutorial.hibernate;

import com.mx.tutorial.hibernate.entities.Medico;
import com.mx.tutorial.hibernate.sessions.HibernateSession;
import java.util.List;
import org.hibernate.Session;
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
            /*
           
            medico = session.get(Medico.class, 3);
             */
            session = HibernateSession.getSessionFactory().openSession();

            Query query = session.createQuery("SELECT m FROM Medico m WHERE m.id = :id");
            query.setParameter("id",3);
            medico = (Medico) query.getSingleResult();
            medicos = query.getResultList();

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (session == null) {
                session.close();

            }
        }
        for(Medico medico1 : medicos){
            System.out.println(medico1);
        }
        
        System.out.println(medico);

    }

}
