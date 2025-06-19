package com.salescontrol.service;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.domain.Product;
import com.salescontrol.exception.CartOperationException;
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

  public void removeItemFromCart(DefaultTableModel cartModel, int selectedRow) {
    int productId = Integer.parseInt(cartModel.getValueAt(selectedRow, 0).toString());
    int quantity = Integer.parseInt(cartModel.getValueAt(selectedRow, 3).toString());

    Product product = productDao.getProductById(productId);
    if (product != null) {
      product.setQuantity(product.getQuantity() + quantity);
      productDao.update(product);

      cartModel.removeRow(selectedRow);
      DataManager.getInstance().removeFromTemporaryCart(productId);
    } else {
      throw new CartOperationException("Produto não encontrado no banco de dados.");
    }
  }
}
