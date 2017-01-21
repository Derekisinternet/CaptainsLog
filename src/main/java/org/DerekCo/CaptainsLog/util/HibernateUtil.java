package org.DerekCo.CaptainsLog.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by Mastermind on 1/16/17.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // create the sessionfactory from hibernate.cfg.xml:
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable except){
            System.err.println("Initial SessionFactory creation failed: " + except);
            throw new ExceptionInInitializerError(except);
        }
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
