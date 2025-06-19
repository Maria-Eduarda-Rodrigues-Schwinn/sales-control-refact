package com.salescontrol.service;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.utils.validation.ProductValidations;

public class ProductService {
  private final ProductDao productDao = new ProductDao();

  public void addProduct(
      String name,
      String quantityStr,
      String unitPriceStr,
      String selectedCategoryDescription,
      String selectedUnitOfMeasure) {

    Product product =
        ProductValidations.parseAndValidate(
            name, quantityStr, unitPriceStr, selectedCategoryDescription, selectedUnitOfMeasure);

    productDao.save(product);
  }
}
