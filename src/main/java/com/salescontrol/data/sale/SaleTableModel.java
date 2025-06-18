package com.salescontrol.data.sale;

import com.salescontrol.domain.Sale;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SaleTableModel extends AbstractTableModel {

  private final List<Sale> sales;

  private final String[] columnNames = {"ID", "Data da Venda", "Valor Total"};

  public SaleTableModel(List<Sale> sales) {
    this.sales = sales;
  }

  @Override
  public int getRowCount() {
    return sales.size();
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
    Sale sale = sales.get(rowIndex);
    return switch (columnIndex) {
      case 0 -> sale.getId();
      case 1 -> sale.getSaleDate();
      case 2 -> sale.getTotalValue();
      default -> null;
    };
  }
}
