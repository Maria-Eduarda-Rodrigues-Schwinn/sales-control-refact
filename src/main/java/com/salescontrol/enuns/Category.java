package com.salescontrol.enuns;

/**
 * Enumeração que representa as categorias de produtos.
 * <p>
 * Esta enumeração define várias categorias de produtos, cada uma com sua
 * respectiva tradução.
 * </p>
 */
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

    /**
     * Tradução da categoria.
     */
    private final String translation;

    /**
     * Construtor para a enumeração Category.
     *
     * @param translation a tradução da categoria.
     */
    Category(String translation) {
        this.translation = translation;
    }

    /**
     * Obtém a tradução da categoria.
     *
     * @return a tradução da categoria.
     */
    public String getTranslation() {
        return translation;
    }
}
