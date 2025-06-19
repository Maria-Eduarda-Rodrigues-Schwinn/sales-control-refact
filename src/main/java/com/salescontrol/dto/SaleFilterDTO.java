package com.salescontrol.dto;

public class SaleFilterDTO {
  private String fromDate;
  private String toDate;
  private String productName;
  private String category;

  public String getFromDate() {
    return fromDate;
  }

  public String getToDate() {
    return toDate;
  }

  public String getProductName() {
    return productName;
  }

  public String getCategory() {
    return category;
  }

  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }

  public void setToDate(String toDate) {
    this.toDate = toDate;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
