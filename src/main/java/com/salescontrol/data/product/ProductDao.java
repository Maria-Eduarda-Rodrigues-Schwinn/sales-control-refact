package com.salescontrol.data.product;

import com.salescontrol.data.TransactionDBUtil;
import com.salescontrol.domain.Product;
import java.util.List;

public class ProductDao {

  public void save(Product product) {
    TransactionDBUtil.execute(em -> em.persist(product));
  }

  public List<Product> getAllProducts() {
    return TransactionDBUtil.executeWithoutTransaction(
        em -> em.createQuery("FROM Product", Product.class).getResultList());
  }

  public void update(Product product) {
    TransactionDBUtil.execute(em -> em.merge(product));
  }

  public boolean delete(int id) {
    return TransactionDBUtil.executeWithResult(
        em -> {
          Product product = em.find(Product.class, id);
          if (product != null) {
            em.remove(product);
            return true;
          } else {
            return false;
          }
        });
  }

  public List<Product> searchProductsByName(String name) {
    return TransactionDBUtil.executeWithoutTransaction(
        em ->
            em.createQuery("FROM Product WHERE name LIKE :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList());
  }

  public Product getProductById(int id) {
    return TransactionDBUtil.executeWithoutTransaction(em -> em.find(Product.class, id));
  }

  public void updateProductQuantity(int productId, int quantity) {
    TransactionDBUtil.execute(
        em -> {
          Product product = em.find(Product.class, productId);
          if (product != null) {
            product.setQuantity(quantity);
            em.merge(product);
          }
        });
  }
}
