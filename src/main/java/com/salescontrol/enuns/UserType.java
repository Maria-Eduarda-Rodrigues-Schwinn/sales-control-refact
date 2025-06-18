package com.salescontrol.enuns;

/**
 * Enumeração que representa diferentes tipos de usuários.
 * <p>
 * Esta enumeração define dois tipos de usuários: ADMIN (Administrador) e
 * EMPLOYEE (Funcionário), cada um com sua respectiva tradução.
 * </p>
 */
public enum UserType {
    ADMIN("Administrador"),
    EMPLOYEE("Funcionário");

    /**
     * Tradução do tipo de usuário.
     */
    private final String translation;

    /**
     * Construtor para a enumeração UserType.
     *
     * @param translation a tradução do tipo de usuário.
     */
    UserType(String translation) {
        this.translation = translation;
    }

    /**
     * Obtém a tradução do tipo de usuário.
     *
     * @return a tradução do tipo de usuário.
     */
    public String getTranslation() {
        return translation;
    }
}
