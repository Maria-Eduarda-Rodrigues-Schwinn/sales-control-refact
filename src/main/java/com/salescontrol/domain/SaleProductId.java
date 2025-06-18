package com.salescontrol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Classe embutida que representa a chave composta para SaleProduct.
 * <p>
 * Esta classe é uma entidade embutida JPA que representa a chave composta para
 * a entidade SaleProduct. Contém os IDs da venda e do produto.
 * </p>
 */
@Embeddable
public class SaleProductId implements Serializable {

    @Column(name = "venda_id")
    private int saleId;

    @Column(name = "produto_id")
    private int productId;

    /**
     * Obtém o ID da venda.
     *
     * @return o ID da venda.
     */
    public int getSaleId() {
        return saleId;
    }

    /**
     * Define o ID da venda.
     *
     * @param saleId o ID da venda.
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    /**
     * Obtém o ID do produto.
     *
     * @return o ID do produto.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Define o ID do produto.
     *
     * @param productId o ID do produto.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Gera o hash code para a chave composta.
     *
     * @return o hash code gerado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * Compara a igualdade entre dois objetos SaleProductId.
     *
     * @param obj o objeto a ser comparado.
     * @return true se os objetos forem iguais, caso contrário false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SaleProductId other = (SaleProductId) obj;
        if (this.saleId != other.saleId) {
            return false;
        }
        return this.productId == other.productId;
    }
}
