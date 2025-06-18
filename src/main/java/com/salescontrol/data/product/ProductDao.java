package com.salescontrol.data.product;

import com.salescontrol.data.JPAUtil;
import com.salescontrol.domain.Product;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductDao {

  private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
  }

  public void save(Product product) {
    EntityManager em = getEntityManager();
    try {
      em.getTransaction().begin();
      em.persist(product);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      throw e;
    } finally {
      em.close();
    }
  }

  public List<Product> getAllProducts() {
    EntityManager em = getEntityManager();
    try {
      return em.createQuery("FROM Product", Product.class).getResultList();
    } finally {
      em.close();
    }
  }

  public void update(Product product) {
    EntityManager em = getEntityManager();
    try {
      em.getTransaction().begin();
      em.merge(product);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      throw e;
    } finally {
      em.close();
    }
  }

  public boolean delete(int id) {
    EntityManager em = getEntityManager();
    try {
      em.getTransaction().begin();
      Product product = em.find(Product.class, id);
      if (product != null) {
        em.remove(product);
        em.getTransaction().commit();
        return true;
      } else {
        em.getTransaction().rollback();
        return false;
      }
    } catch (Exception e) {
      em.getTransaction().rollback();
      throw e;
    } finally {
      em.close();
    }
  }

  public List<Product> searchProductsByName(String name) {
    EntityManager em = getEntityManager();
    try {
      return em.createQuery("FROM Product WHERE name LIKE :name", Product.class)
          .setParameter("name", "%" + name + "%")
          .getResultList();
    } finally {
      em.close();
    }
  }

  public Product getProductById(int id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Product.class, id);
    } finally {
      em.close();
    }
  }

  public void updateProductQuantity(int productId, int quantity) {
    EntityManager em = getEntityManager();
    try {
      em.getTransaction().begin();
      Product product = em.find(Product.class, productId);
      if (product != null) {
        product.setQuantity(quantity);
        em.merge(product);
      }
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      throw e;
    } finally {
      em.close();
    }
  }
}
