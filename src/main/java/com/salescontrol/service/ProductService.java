package com.salescontrol.service;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UnitOfMeasure;
import com.salescontrol.exception.ProductValidationException;
import com.salescontrol.utils.validation.ProductValidations;

public class ProductService {
  private final ProductDao productDao = new ProductDao();

  public void addProduct(
      String name,
      String quantityStr,
      String unitPriceStr,
      String selectedCategoryDescription,
      String selectedUnitOfMeasure) {
    if (name.isEmpty() || quantityStr.isEmpty() || unitPriceStr.isEmpty()) {

      throw new ProductValidationException("Todos os campos devem ser preenchidos.");
    }

    int quantity;
    double unitPrice;

    try {
      quantity = Integer.parseInt(quantityStr);
    } catch (NumberFormatException e) {
      throw new ProductValidationException("A quantidade deve ser um número inteiro.");
    }

    try {
      unitPrice = Double.parseDouble(unitPriceStr);
    } catch (NumberFormatException e) {
      throw new ProductValidationException("O preço unitário deve ser um número.");
    }

    Category category = getCategoryFromDescription(selectedCategoryDescription);
    UnitOfMeasure unitOfMeasure = getUnitOfMeasureFromDescription(selectedUnitOfMeasure);

    Product product = new Product();
    product.setName(name);
    product.setCategory(category);
    product.setUnitPrice(unitPrice);
    product.setUnitOfMeasure(unitOfMeasure);
    product.setQuantity(quantity);

    ProductValidations.validate(product);
    productDao.save(product);
  }

  private Category getCategoryFromDescription(String description) {
    for (Category category : Category.values()) {
      if (category.getTranslation().equals(description)) {
        return category;
      }
    }
    return null;
  }

  private UnitOfMeasure getUnitOfMeasureFromDescription(String description) {
    for (UnitOfMeasure unitOfMeasure : UnitOfMeasure.values()) {
      if (unitOfMeasure.getTranslation().equals(description)) {
        return unitOfMeasure;
      }
    }
    return null;
  }
}
