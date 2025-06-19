package com.salescontrol.service;

import static com.salescontrol.utils.validation.ProductValidations.validateQuantity;
import static com.salescontrol.utils.validation.ProductValidations.validateUnitPrice;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.exception.ProductNotFoundException;
import com.salescontrol.utils.validation.ProductValidations;
import java.util.List;

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

  public void updateProduct(int productId, String newUnitPriceStr, String newQuantityStr) {
    Product product = productDao.getProductById(productId);
    if (product == null) throw new ProductNotFoundException("Produto não encontrado.");

    double unitPrice = validateUnitPrice(newUnitPriceStr);
    int quantity = validateQuantity(newQuantityStr);

    product.setUnitPrice(unitPrice);
    product.setQuantity(quantity);
    productDao.update(product);
  }

  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }
}
