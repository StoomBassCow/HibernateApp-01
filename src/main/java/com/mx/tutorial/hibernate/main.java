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
import org.hibernate.Transaction;

/**
 *
 * @author cesar.huerta
 */
public class main {

    public static void main(String[] args) {

        Session session = null;
        Medico medico = null;
        List<Medico> medicos = null;
        Transaction tx = null;

        try {

            session = HibernateSession.getSessionFactory().openSession();
            tx = session.beginTransaction();
            //Guardar
            session.save(null);
            //Actualizar
            session.update(null);
            //Eliminar
            session.delete(null);

        } catch (Exception e) {
            tx.rollback();
        } finally {
            if (session == null) {
                session.close();
            }
        }

        for (Medico medico1 : medicos) {
            System.out.println(medico1);
        }

    }

}
