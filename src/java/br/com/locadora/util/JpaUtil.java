package br.com.locadora.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public static EntityManager getManager() {
        if (manager != null) {
            return manager;
        } else {
            factory = Persistence.createEntityManagerFactory("WebAppLocadoraPU");
            manager = factory.createEntityManager();

            return manager;
        }
    }

    public static void close() {
        manager.close();
        factory.close();
    }
}
