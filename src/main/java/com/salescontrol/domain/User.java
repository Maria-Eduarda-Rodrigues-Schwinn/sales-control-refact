package com.salescontrol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.salescontrol.enuns.UserType;

import java.io.Serializable;

/**
 * Classe de domínio que representa um usuário no sistema.
 * <p>
 * Esta classe é uma entidade JPA que mapeia para a tabela "usuario" no banco de
 * dados. Representa as informações de um usuário, incluindo ID, nome, login,
 * senha e tipo de usuário.
 * </p>
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "senha", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private UserType userType;

    /**
     * Obtém o ID do usuário.
     *
     * @return o ID do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     *
     * @param id o ID do usuário.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return o nome do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do usuário.
     *
     * @param name o nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o login do usuário.
     *
     * @return o login do usuário.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o login do usuário.
     *
     * @param login o login do usuário.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return a senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     *
     * @param password a senha do usuário.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtém o tipo de usuário.
     *
     * @return o tipo de usuário.
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Define o tipo de usuário.
     *
     * @param userType o tipo de usuário.
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
