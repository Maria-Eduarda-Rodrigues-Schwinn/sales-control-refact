package com.salescontrol.exception;

public class SaleNotFoundException extends RuntimeException {
  public SaleNotFoundException(String message) {
    super(message);
  }
}
