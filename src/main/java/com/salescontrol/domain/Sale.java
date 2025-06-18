package com.salescontrol.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(Date saleDate) {
    this.saleDate = saleDate;
  }

  public double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(double totalValue) {
    this.totalValue = totalValue;
  }

  public List<SaleProduct> getProductsSold() {
    return productsSold;
  }

  public void setProductsSold(List<SaleProduct> productsSold) {
    this.productsSold = productsSold;
  }
}
