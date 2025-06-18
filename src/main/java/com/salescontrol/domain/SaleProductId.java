package com.salescontrol.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SaleProductId implements Serializable {

  @Column(name = "venda_id")
  private int saleId;

  @Column(name = "produto_id")
  private int productId;

  public int getSaleId() {
    return saleId;
  }

  public void setSaleId(int saleId) {
    this.saleId = saleId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    return hash;
  }

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
