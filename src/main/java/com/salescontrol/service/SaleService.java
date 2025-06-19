package com.salescontrol.service;

import static com.salescontrol.utils.validation.ProductValidations.validateQuantity;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.data.sale.SaleDao;
import com.salescontrol.domain.Product;
import com.salescontrol.domain.Sale;
import com.salescontrol.domain.SaleProduct;
import com.salescontrol.exception.SaleNotFoundException;
import com.salescontrol.exception.SaleValidationException;
import java.util.Date;
import java.util.List;

public class SaleService {
  private final ProductDao productDao = new ProductDao();
  private final SaleDao saleDao = new SaleDao();

  public Product addProductToCart(int productId, String quantityStr) {
    int quantity = validateQuantity(quantityStr);

    Product product = productDao.getProductById(productId);
    if (product == null) throw new SaleNotFoundException("Produto não encontrado.");

    if (quantity > product.getQuantity())
      throw new SaleValidationException(
          "A quantidade inserida é maior do que a disponível em estoque.");

    product.setQuantity(product.getQuantity() - quantity);
    productDao.update(product);
    return product;
  }

  public void finalizeSale(List<SaleProduct> saleProducts) {
    if (saleProducts == null || saleProducts.isEmpty()) {
      throw new SaleValidationException("O carrinho está vazio.");
    }

    Sale sale = new Sale();
    sale.setSaleDate(new Date());

    double total = 0.0;
    for (SaleProduct sp : saleProducts) {
      total += sp.getQuantity() * sp.getUnitPrice();
    }

    sale.setTotalValue(total);

    saleDao.saveSaleWithProducts(sale, saleProducts);
  }
}
