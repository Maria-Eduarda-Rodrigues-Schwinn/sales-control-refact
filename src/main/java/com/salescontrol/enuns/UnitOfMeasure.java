package com.salescontrol.enuns;

/**
 * Enumeração que representa as unidades de medida.
 * <p>
 * Esta enumeração define várias unidades de medida, cada uma com sua respectiva
 * tradução.
 * </p>
 */
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

    /**
     * Tradução da unidade de medida.
     */
    private final String translation;

    /**
     * Construtor para a enumeração UnitOfMeasure.
     *
     * @param translation a tradução da unidade de medida.
     */
    UnitOfMeasure(String translation) {
        this.translation = translation;
    }

    /**
     * Obtém a tradução da unidade de medida.
     *
     * @return a tradução da unidade de medida.
     */
    public String getTranslation() {
        return translation;
    }
}
