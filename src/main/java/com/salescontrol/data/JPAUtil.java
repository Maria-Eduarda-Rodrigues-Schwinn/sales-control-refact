package com.salescontrol.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utilitário para gerenciar o EntityManager e a EntityManagerFactory.
 * <p>
 * Esta classe fornece métodos para obter e fechar instâncias de EntityManager
 * e EntityManagerFactory, que são usados para gerenciar operações de banco de dados
 * na aplicação.
 * </p>
 */
public class JPAUtil {

    /** Nome da unidade de persistência. */
    private static final String PERSISTENCE_UNIT = "SalesControl-PU";

    /** Instância de EntityManager. */
    private static EntityManager em;

    /** Instância de EntityManagerFactory. */
    private static EntityManagerFactory factory;

    /**
     * Obtém a instância de EntityManager.
     * <p>
     * Este método garante que a instância de EntityManagerFactory e EntityManager
     * sejam criadas e abertas, se ainda não estiverem.
     * </p>
     *
     * @return a instância de EntityManager.
     */
    public static EntityManager getEntityManager() {
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (em == null || !em.isOpen()) {
            em = factory.createEntityManager();
        }

        return em;
    }

    /**
     * Fecha o EntityManager e a EntityManagerFactory.
     * <p>
     * Este método fecha a instância de EntityManager e EntityManagerFactory,
     * se estiverem abertas.
     * </p>
     */
    public static void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}

