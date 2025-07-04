package com.salescontrol.enuns;

public enum Category {
  FOOD("Alimentos"),
  BEVERAGES("Bebidas"),
  PERSONAL_HYGIENE("Higiene Pessoal"),
  CLEANING("Limpeza"),
  ELECTRONICS("Eletrônicos"),
  CLOTHING("Roupas"),
  FURNITURE("Móveis"),
  BOOKS("Livros"),
  TOYS("Brinquedos"),
  OTHERS("Outros");

  private final String translation;

  Category(String translation) {
    this.translation = translation;
  }

  public String getTranslation() {
    return translation;
  }
}
