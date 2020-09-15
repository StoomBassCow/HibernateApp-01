/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.tutorial.hibernate.sessions;

import com.mx.tutorial.hibernate.entities.Medico;
import com.mx.tutorial.hibernate.entities.Paciente;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



/**
 *
 * @author cesar.huerta
 */
public class HibernateSession {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                 Configuration cfg = new Configuration();

            Properties prop = new Properties();

            prop.put("hibernate.dialecxt", "org.hibernate.dialect.MySQLDialect");
            prop.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull");
            prop.put("hibernate.connection.username", "root");

            cfg.setProperties(prop);
            cfg.addAnnotatedClass(Medico.class);
            cfg.addAnnotatedClass(Paciente.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();

            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return sessionFactory;
    }
    
}
