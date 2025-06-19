package com.salescontrol.service;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.utils.DataManager;
import javax.swing.table.DefaultTableModel;

public class CartService {
  private final ProductDao productDao = new ProductDao();

  public void clearCart(DefaultTableModel cartModel) {
    for (int i = 0; i < cartModel.getRowCount(); i++) {
      Object productIdObject = cartModel.getValueAt(i, 0);
      int productId = Integer.parseInt(productIdObject.toString());

      Object quantityObject = cartModel.getValueAt(i, 3);
      int quantity = Integer.parseInt(quantityObject.toString());

      Product product = productDao.getProductById(productId);
      if (product != null) {
        product.setQuantity(product.getQuantity() + quantity);
        productDao.update(product);
      }
    }
    cartModel.setRowCount(0);
    DataManager.getInstance().clearTemporaryCart();
  }
}
