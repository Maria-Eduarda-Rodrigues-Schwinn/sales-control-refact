package com.salescontrol.utils;

import java.util.Date;
import javax.swing.JOptionPane;

public class ValidationUtils {

  public static void validateSaleInputs(Date saleDate, double totalValue) {
    if (saleDate == null || !isValidDate(saleDate)) {
      JOptionPane.showMessageDialog(
          null,
          "Data de venda inválida. Por favor, insira uma data válida.",
          "Erro",
          JOptionPane.ERROR_MESSAGE);
      throw new IllegalArgumentException("Data de venda inválida.");
    }

    if (totalValue <= 0) {
      JOptionPane.showMessageDialog(
          null,
          "Valor total inválido. Deve ser um valor positivo.",
          "Erro",
          JOptionPane.ERROR_MESSAGE);
      throw new IllegalArgumentException("Valor total inválido.");
    }
  }

  public static boolean isValidDate(Date date) {
    return date.before(new Date());
  }
}
