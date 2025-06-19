package com.salescontrol.data.product;

import com.salescontrol.data.GenericDao;
import com.salescontrol.data.TransactionDBUtil;
import com.salescontrol.domain.Product;
import java.util.List;

public class ProductDao {

  private final GenericDao<Product> genericDao = new GenericDao<>(Product.class);

  public void save(Product product) {
    genericDao.save(product);
  }

  public Product getProductById(int id) {
    return genericDao.findById(id);
  }

  public List<Product> getAllProducts() {
    return genericDao.findAll();
  }

  public void update(Product product) {
    genericDao.update(product);
  }

  public boolean delete(int id) {
    return genericDao.deleteById(id);
  }

  public List<Product> searchProductsByName(String name) {
    return TransactionDBUtil.executeWithoutTransaction(
        em ->
            em.createQuery("FROM Product WHERE name LIKE :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList());
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
