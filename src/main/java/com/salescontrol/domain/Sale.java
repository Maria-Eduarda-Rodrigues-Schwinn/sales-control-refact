package com.salescontrol.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * Classe de domínio que representa uma venda no sistema.
 * <p>
 * Esta classe é uma entidade JPA que mapeia para a tabela "venda" no banco de
 * dados. Representa as informações de uma venda, incluindo ID, data da venda,
 * valor total e produtos vendidos.
 * </p>
 */
@Entity
@Table(name = "venda")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "datavenda", nullable = false)
    private Date saleDate;

    @Column(name = "valortotal", nullable = false)
    private double totalValue;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleProduct> productsSold;

    /**
     * Obtém o ID da venda.
     *
     * @return o ID da venda.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID da venda.
     *
     * @param id o ID da venda.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a data da venda.
     *
     * @return a data da venda.
     */
    public Date getSaleDate() {
        return saleDate;
    }

    /**
     * Define a data da venda.
     *
     * @param saleDate a data da venda.
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * Obtém o valor total da venda.
     *
     * @return o valor total da venda.
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * Define o valor total da venda.
     *
     * @param totalValue o valor total da venda.
     */
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * Obtém a lista de produtos vendidos.
     *
     * @return a lista de produtos vendidos.
     */
    public List<SaleProduct> getProductsSold() {
        return productsSold;
    }

    /**
     * Define a lista de produtos vendidos.
     *
     * @param productsSold a lista de produtos vendidos.
     */
    public void setProductsSold(List<SaleProduct> productsSold) {
        this.productsSold = productsSold;
    }
}
