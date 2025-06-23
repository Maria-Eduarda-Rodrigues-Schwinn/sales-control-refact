package com.salescontrol.service;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.exception.CartOperationException;
import com.salescontrol.utils.DataManager;
import javax.swing.table.DefaultTableModel;

public class CartService {
  private final ProductDao productDao = new ProductDao();

  public void clearCart(DefaultTableModel cartModel) {
    for (var i = 0; i < cartModel.getRowCount(); i++) {
      var productIdObject = cartModel.getValueAt(i, 0);
      var productId = Integer.parseInt(productIdObject.toString());

      var quantityObject = cartModel.getValueAt(i, 3);
      var quantity = Integer.parseInt(quantityObject.toString());

      var product = productDao.getProductById(productId);
      if (product != null) {
        product.setQuantity(product.getQuantity() + quantity);
        productDao.update(product);
      }
    }
    cartModel.setRowCount(0);
    DataManager.getInstance().clearTemporaryCart();
  }

  public void removeItemFromCart(DefaultTableModel cartModel, int selectedRow) {
    var productId = Integer.parseInt(cartModel.getValueAt(selectedRow, 0).toString());
    var quantity = Integer.parseInt(cartModel.getValueAt(selectedRow, 3).toString());

    var product = productDao.getProductById(productId);
    if (product != null) {
      product.setQuantity(product.getQuantity() + quantity);
      productDao.update(product);

      cartModel.removeRow(selectedRow);
      DataManager.getInstance().removeFromTemporaryCart(productId);
    } else {
      throw new CartOperationException("Produto não encontrado no banco de dados.");
    }
  }

  public void restoreStockFromCart() {
    var temporaryCart = DataManager.getInstance().getTemporaryCart();

    for (var entry : temporaryCart.entrySet()) {
      int productId = entry.getKey();
      int quantity = entry.getValue();

      var product = productDao.getProductById(productId);
      if (product != null) {
        product.setQuantity(product.getQuantity() + quantity);
        productDao.update(product);
      }
    }

    DataManager.getInstance().clearTemporaryCart();
  }
}
