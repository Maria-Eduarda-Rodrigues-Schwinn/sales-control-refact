package com.salescontrol.exception;

public class SaleValidationException extends RuntimeException {
  public SaleValidationException(String message) {
    super(message);
  }

  public SaleValidationException(String message, Throwable cause) {
    super(message, cause);
  }
}
