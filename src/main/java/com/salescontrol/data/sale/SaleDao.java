package com.salescontrol.data.sale;

import com.salescontrol.data.GenericDao;
import com.salescontrol.data.TransactionDBUtil;
import com.salescontrol.domain.Sale;
import com.salescontrol.domain.SaleProduct;
import com.salescontrol.enuns.Category;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;

public class SaleDao {

  private final GenericDao<Sale> genericDao = new GenericDao<>(Sale.class);

  public void save(Sale sale) {
    genericDao.save(sale);
  }

  public List<Sale> getAllSales() {
    return TransactionDBUtil.executeWithoutTransaction(
        em -> {
          var sales = em.createQuery("FROM Sale", Sale.class).getResultList();
          for (var sale : sales) {
            Hibernate.initialize(sale.getProductsSold());
          }
          return sales;
        });
  }

  public void saveSaleWithProducts(Sale sale, List<SaleProduct> saleProducts) {
    TransactionDBUtil.execute(
        em -> {
          var mergedSale = em.merge(sale);
          for (var saleProduct : saleProducts) {
            saleProduct.setSale(mergedSale);
            saleProduct.setProduct(em.merge(saleProduct.getProduct()));
            em.merge(saleProduct);
          }
        });
  }

  public List<Sale> filterSalesByDate(Date startDate, Date endDate) {
    return TransactionDBUtil.executeWithoutTransaction(
        em ->
            em.createQuery("FROM Sale WHERE saleDate BETWEEN :startDate AND :endDate", Sale.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList());
  }

  public List<Sale> filterSalesByCategory(Category category) {
    return TransactionDBUtil.executeWithoutTransaction(
        em ->
            em.createQuery(
                    "SELECT s FROM Sale s JOIN s.productsSold p WHERE p.product.category = :category",
                    Sale.class)
                .setParameter("category", category)
                .getResultList());
  }

  public List<Sale> filterSalesByProductName(String productName) {
    return TransactionDBUtil.executeWithoutTransaction(
        em ->
            em.createQuery(
                    "SELECT s FROM Sale s JOIN s.productsSold p WHERE p.product.name LIKE :productName",
                    Sale.class)
                .setParameter("productName", "%" + productName + "%")
                .getResultList());
  }
}
