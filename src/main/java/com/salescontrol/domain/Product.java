package com.salescontrol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UnitOfMeasure;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.io.Serializable;

/**
 * Classe de domínio que representa um produto no sistema.
 * <p>
 * Esta classe é uma entidade JPA que mapeia para a tabela "produto" no banco de
 * dados. Representa as informações de um produto, incluindo ID, nome,
 * categoria, preço unitário, unidade de medida e quantidade.
 * </p>
 */
@Entity
@Table(name = "produto")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false)
    private Category category;

    @Column(name = "precounitario", nullable = false)
    private double unitPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "unidademedida", nullable = false)
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "quantidade", nullable = false)
    private int quantity;

    /**
     * Obtém o ID do produto.
     *
     * @return o ID do produto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id o ID do produto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return o nome do produto.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do produto.
     *
     * @param name o nome do produto.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a categoria do produto.
     *
     * @return a categoria do produto.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Define a categoria do produto.
     *
     * @param category a categoria do produto.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Obtém o preço unitário do produto.
     *
     * @return o preço unitário do produto.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Define o preço unitário do produto.
     *
     * @param unitPrice o preço unitário do produto.
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Obtém a unidade de medida do produto.
     *
     * @return a unidade de medida do produto.
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Define a unidade de medida do produto.
     *
     * @param unitOfMeasure a unidade de medida do produto.
     */
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * Obtém a quantidade do produto.
     *
     * @return a quantidade do produto.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Define a quantidade do produto.
     *
     * @param quantity a quantidade do produto.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
