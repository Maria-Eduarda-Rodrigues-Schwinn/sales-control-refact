package com.salescontrol.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
  private static final String PERSISTENCE_UNIT = "SalesControl-PU";
  private static EntityManagerFactory factory;

  public static EntityManager getEntityManager() {
    if (factory == null || !factory.isOpen()) {
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    return factory.createEntityManager();
  }

  public static void closeFactory() {
    if (factory != null && factory.isOpen()) {
      factory.close();
    }
  }
}
