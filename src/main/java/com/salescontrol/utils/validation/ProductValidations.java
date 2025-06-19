package com.salescontrol.utils.validation;

import com.salescontrol.domain.Product;
import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UnitOfMeasure;
import com.salescontrol.exception.ProductValidationException;
import java.util.regex.Pattern;

public class ProductValidations {
  private static final int MAX_NAME_LENGTH = 100;

  public static Product parseAndValidate(
      String name,
      String quantityStr,
      String unitPriceStr,
      String selectedCategoryDescription,
      String selectedUnitOfMeasure) {

    if (name.isEmpty() || quantityStr.isEmpty() || unitPriceStr.isEmpty())
      throw new ProductValidationException("Todos os campos devem ser preenchidos.");

    Category category = getCategoryFromDescription(selectedCategoryDescription);
    if (category == null) throw new ProductValidationException("Categoria inválida.");

    UnitOfMeasure unitOfMeasure = getUnitOfMeasureFromDescription(selectedUnitOfMeasure);
    if (unitOfMeasure == null) throw new ProductValidationException("Unidade de medida inválida.");

    Product product = new Product();
    product.setName(name);
    product.setQuantity(validateQuantity(quantityStr));
    product.setUnitPrice(validateUnitPrice(unitPriceStr));
    product.setCategory(category);
    product.setUnitOfMeasure(unitOfMeasure);

    validate(product);

    return product;
  }

  private static void validate(Product product) {
    if (!isValidName(product.getName()))
      throw new ProductValidationException(
          "Nome inválido. Não deve estar vazio, não deve conter apenas números e deve ter no máximo "
              + MAX_NAME_LENGTH
              + " caracteres.");

    if (!isValidCategory(product.getCategory().getTranslation()))
      throw new ProductValidationException(
          "Categoria inválida. Por favor, selecione uma categoria válida.");

    if (!isValidUnitOfMeasure(product.getUnitOfMeasure().getTranslation()))
      throw new ProductValidationException(
          "Unidade de medida inválida. Por favor, selecione uma unidade de medida válida.");
  }

  private static boolean isValidName(String name) {
    return !name.isEmpty() && !Pattern.matches("\\d+", name) && name.length() <= MAX_NAME_LENGTH;
  }

  private static boolean isValidCategory(String category) {
    for (Category c : Category.values()) {
      if (c.getTranslation().equals(category)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isValidUnitOfMeasure(String unitOfMeasure) {
    for (UnitOfMeasure uom : UnitOfMeasure.values()) {
      if (uom.getTranslation().equals(unitOfMeasure)) {
        return true;
      }
    }
    return false;
  }

  private static Category getCategoryFromDescription(String description) {
    for (Category category : Category.values()) {
      if (category.getTranslation().equals(description)) {
        return category;
      }
    }
    return null;
  }

  private static UnitOfMeasure getUnitOfMeasureFromDescription(String description) {
    for (UnitOfMeasure unitOfMeasure : UnitOfMeasure.values()) {
      if (unitOfMeasure.getTranslation().equals(description)) {
        return unitOfMeasure;
      }
    }
    return null;
  }

  public static double validateUnitPrice(String unitPriceStr) {
    try {
      double unitPrice = Double.parseDouble(unitPriceStr);

      if (unitPrice <= 0)
        throw new ProductValidationException(
            "Preço unitário inválido. Deve ser um valor positivo.");

      return unitPrice;

    } catch (NumberFormatException e) {
      throw new ProductValidationException("O preço unitário deve ser um número válido.", e);
    }
  }

  public static int validateQuantity(String quantityStr) {
    try {
      int quantity = Integer.parseInt(quantityStr);

      if (quantity < 0)
        throw new ProductValidationException("Quantidade inválida. Deve ser um valor positivo.");

      return quantity;

    } catch (NumberFormatException e) {
      throw new ProductValidationException("A quantidade deve ser um número inteiro.", e);
    }
  }
}
