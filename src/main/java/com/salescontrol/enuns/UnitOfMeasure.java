package com.salescontrol.enuns;

public enum UnitOfMeasure {
  UNIT("Unidade"),
  GRAMS("Gramas"),
  KILOS("Kilos"),
  LITERS("Litros"),
  MILLILITRES("Mililitros"),
  PACKAGE("Pacote"),
  BOX("Caixa"),
  METERS("Metros"),
  SQUARE_METERS("Metros Quadrados"),
  OTHERS("Outros");

  private final String translation;

  UnitOfMeasure(String translation) {
    this.translation = translation;
  }

  public String getTranslation() {
    return translation;
  }
}
