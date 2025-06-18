package com.salescontrol.enuns;

public enum UserType {
  ADMIN("Administrador"),
  EMPLOYEE("Funcionário");

  private final String translation;

  UserType(String translation) {
    this.translation = translation;
  }

  public String getTranslation() {
    return translation;
  }
}
