package com.salescontrol.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionDBUtil {

  public static void execute(Consumer<EntityManager> action) {
    EntityManager em = JPAUtil.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      action.accept(em);
      tx.commit();
    } catch (Exception e) {
      if (tx.isActive()) {
        tx.rollback();
      }
      throw e;
    } finally {
      em.close();
    }
  }

  public static <R> R executeWithResult(Function<EntityManager, R> action) {
    EntityManager em = JPAUtil.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      R result = action.apply(em);
      tx.commit();
      return result;
    } catch (Exception e) {
      if (tx.isActive()) {
        tx.rollback();
      }
      throw e;
    } finally {
      em.close();
    }
  }

  public static <R> R executeWithoutTransaction(Function<EntityManager, R> action) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
      return action.apply(em);
    } finally {
      em.close();
    }
  }
}
