package com.salescontrol.service;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.utils.validation.ProductValidations;

public class ProductService {
  private final ProductDao productDao = new ProductDao();

  public void addProduct(Product product) {
    ProductValidations.validate(product);
    productDao.save(product);
  }
}
