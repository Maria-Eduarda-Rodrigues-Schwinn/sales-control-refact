package com.salescontrol.exception;

public class ProductValidationException extends RuntimeException {
  public ProductValidationException(String message) {
    super(message);
  }

  public ProductValidationException(String message, Throwable cause) {
    super(message, cause);
  }
}
