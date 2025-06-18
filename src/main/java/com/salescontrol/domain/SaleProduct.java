package com.salescontrol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "venda_produto")
public class SaleProduct implements Serializable {

  @EmbeddedId private SaleProductId id = new SaleProductId();

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

  public SaleProduct() {}

  public SaleProduct(Product product, int quantity, double unitPrice) {
    this.product = product;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.totalValue = quantity * unitPrice;
  }

  public SaleProductId getId() {
    return id;
  }

  public void setId(SaleProductId id) {
    this.id = id;
  }

  public Sale getSale() {
    return sale;
  }

  public void setSale(Sale sale) {
    this.sale = sale;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(double totalValue) {
    this.totalValue = totalValue;
  }
}
