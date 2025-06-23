package com.salescontrol.utils.validation;

import com.salescontrol.dto.SaleFilterDTO;
import com.salescontrol.exception.SaleValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleValidations {

  public static FilterParsedData parseAndValidate(SaleFilterDTO saleFilter) {
    var dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);

    Date fromDate = null;
    Date toDate = null;

    try {
      if (saleFilter.getFromDate() != null && !saleFilter.getFromDate().isBlank()) {
        fromDate = dateFormat.parse(saleFilter.getFromDate());
      }

      if (saleFilter.getToDate() != null && !saleFilter.getToDate().isBlank()) {
        toDate = dateFormat.parse(saleFilter.getToDate());
      }

      if (fromDate != null && toDate != null && fromDate.after(toDate)) {
        throw new SaleValidationException("A data inicial deve ser antes da data final.");
      }

    } catch (ParseException e) {
      throw new SaleValidationException("Formato de data inválido. Use o formato dd/MM/yyyy.");
    }

    return new FilterParsedData(
        fromDate, toDate, saleFilter.getProductName(), saleFilter.getCategory());
  }

  public static class FilterParsedData {
    private Date fromDate;
    private Date toDate;
    private String productName;
    private String category;

    public FilterParsedData(Date fromDate, Date toDate, String productName, String category) {
      this.fromDate = fromDate;
      this.toDate = toDate;
      this.productName = productName;
      this.category = category;
    }

    public Date getFromDate() {
      return fromDate;
    }

    public Date getToDate() {
      return toDate;
    }

    public String getProductName() {
      return productName;
    }

    public String getCategory() {
      return category;
    }
  }
}
