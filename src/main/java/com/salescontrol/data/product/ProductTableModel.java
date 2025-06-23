package com.salescontrol.data.product;

import com.salescontrol.domain.Product;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductTableModel extends AbstractTableModel {

  private final List<Product> products;

  private final String[] columnNames = {
    "ID", "Nome", "Categoria", "Preço Unitário", "Unidade de Medida", "Quantidade"
  };

  public ProductTableModel(List<Product> products) {
    this.products = products;
  }

  @Override
  public int getRowCount() {
    return products.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    var product = products.get(rowIndex);
    return switch (columnIndex) {
      case 0 -> product.getId();
      case 1 -> product.getName();
      case 2 -> product.getCategory().getTranslation();
      case 3 -> product.getUnitPrice();
      case 4 -> product.getUnitOfMeasure().getTranslation();
      case 5 -> product.getQuantity();
      default -> null;
    };
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }
}
