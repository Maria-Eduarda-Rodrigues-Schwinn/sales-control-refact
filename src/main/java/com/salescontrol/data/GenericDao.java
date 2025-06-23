package com.salescontrol.data;

import java.util.List;

public class GenericDao<T> {

  private final Class<T> type;

  public GenericDao(Class<T> type) {
    this.type = type;
  }

  public void save(T entity) {
    TransactionDBUtil.execute(em -> em.persist(entity));
  }

  public T findById(int id) {
    return TransactionDBUtil.executeWithoutTransaction(em -> em.find(type, id));
  }

  public List<T> findAll() {
    return TransactionDBUtil.executeWithoutTransaction(
        em -> em.createQuery("FROM " + type.getSimpleName(), type).getResultList());
  }

  public void update(T entity) {
    TransactionDBUtil.execute(em -> em.merge(entity));
  }

  public boolean deleteById(int id) {
    return TransactionDBUtil.executeWithResult(
        em -> {
          var entity = em.find(type, id);
          if (entity != null) {
            em.remove(entity);
            return true;
          }
          return false;
        });
  }
}
