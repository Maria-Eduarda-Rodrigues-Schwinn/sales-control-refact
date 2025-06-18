package com.salescontrol.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

  private static final String PERSISTENCE_UNIT = "SalesControl-PU";

  private static EntityManager em;

  private static EntityManagerFactory factory;

  public static EntityManager getEntityManager() {
    if (factory == null || !factory.isOpen()) {
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    if (em == null || !em.isOpen()) {
      em = factory.createEntityManager();
    }

    return em;
  }

  public static void closeEntityManager() {
    if (em != null && em.isOpen()) {
      em.close();
    }
    if (factory != null && factory.isOpen()) {
      factory.close();
    }
  }
}
