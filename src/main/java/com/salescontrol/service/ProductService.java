package com.salescontrol.service;

import static com.salescontrol.utils.validation.ProductValidations.validateQuantity;
import static com.salescontrol.utils.validation.ProductValidations.validateUnitPrice;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.exception.ProductNotFoundException;
import com.salescontrol.exception.ProductOperationException;
import com.salescontrol.exception.ProductValidationException;
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

  public Product getProductById(int id) {
    return productDao.getProductById(id);
  }

  public void deleteProduct(int productId) {
    boolean deleted = productDao.delete(productId);
    if (!deleted) throw new ProductOperationException("Erro ao excluir o produto.");
  }

  public List<Product> searchProductsByName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new ProductValidationException("Nome do produto não pode estar vazio.");
    }

    return productDao.searchProductsByName(name.trim());
  }
}
