package com.salescontrol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 * Classe de domínio que representa a associação entre venda e produto.
 * <p>
 * Esta classe é uma entidade JPA que mapeia para a tabela "venda_produto" no
 * banco de dados. Representa a associação entre uma venda e um produto,
 * incluindo a quantidade e os preços.
 * </p>
 */
@Entity
@Table(name = "venda_produto")
public class SaleProduct implements Serializable {

    @EmbeddedId
    private SaleProductId id = new SaleProductId();

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "venda_id")
    private Sale sale;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "produto_id")
    private Product product;

    @Column(name = "quantidade", nullable = false)
    private int quantity;

    @Column(name = "precounitario", nullable = false)
    private double unitPrice;

    @Column(name = "valortotal", nullable = false)
    private double totalValue;

    /**
     * Construtor padrão para a classe SaleProduct.
     */
    public SaleProduct() {
    }

    /**
     * Construtor para inicializar a classe SaleProduct com um produto,
     * quantidade e preço unitário.
     *
     * @param product o produto associado à venda.
     * @param quantity a quantidade do produto vendido.
     * @param unitPrice o preço unitário do produto.
     */
    public SaleProduct(Product product, int quantity, double unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalValue = quantity * unitPrice;
    }

    /**
     * Obtém o ID da associação entre venda e produto.
     *
     * @return o ID da associação.
     */
    public SaleProductId getId() {
        return id;
    }

    /**
     * Define o ID da associação entre venda e produto.
     *
     * @param id o ID da associação.
     */
    public void setId(SaleProductId id) {
        this.id = id;
    }

    /**
     * Obtém a venda associada.
     *
     * @return a venda associada.
     */
    public Sale getSale() {
        return sale;
    }

    /**
     * Define a venda associada.
     *
     * @param sale a venda associada.
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }

    /**
     * Obtém o produto associado.
     *
     * @return o produto associado.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Define o produto associado.
     *
     * @param product o produto associado.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Obtém a quantidade do produto vendido.
     *
     * @return a quantidade do produto vendido.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Define a quantidade do produto vendido.
     *
     * @param quantity a quantidade do produto vendido.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
     * Obtém o valor total da venda do produto.
     *
     * @return o valor total da venda do produto.
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * Define o valor total da venda do produto.
     *
     * @param totalValue o valor total da venda do produto.
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
