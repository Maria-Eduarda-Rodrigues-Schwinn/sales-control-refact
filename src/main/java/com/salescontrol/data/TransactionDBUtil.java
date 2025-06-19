package com.salescontrol.data;

import com.salescontrol.exception.DaoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionDBUtil {

  public static void execute(Consumer<EntityManager> action) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                action.accept(em);
                tx.commit();
            } catch (Exception e) {
                if (tx.isActive()) tx.rollback();
                throw new DaoException("Error executing a transaction on the database: ", e);
            }
        }
    }

  public static <R> R executeWithResult(Function<EntityManager, R> action) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                R result = action.apply(em);
                tx.commit();
                return result;
            } catch (Exception e) {
                if (tx.isActive()) tx.rollback();
                throw new DaoException("Error executing transaction with return in database: ", e);
            }
        }
    }

  public static <R> R executeWithoutTransaction(Function<EntityManager, R> action) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return action.apply(em);
        } catch (Exception e) {
            throw new DaoException("Error executing query without transaction on database: ", e);
        }
    }
}
