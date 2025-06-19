package com.salescontrol.data.sale;

import com.salescontrol.data.GenericDao;
import com.salescontrol.data.TransactionDBUtil;
import com.salescontrol.domain.Sale;
import com.salescontrol.domain.SaleProduct;
import com.salescontrol.enuns.Category;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;

public class SaleDao {

    private final GenericDao<Sale> genericDao = new GenericDao<>(Sale.class);

    public void save(Sale sale) {
        genericDao.save(sale);
    }

    public List<Sale> getAllSales() {
        return TransactionDBUtil.executeWithoutTransaction(em -> {
            List<Sale> sales = em.createQuery("FROM Sale", Sale.class).getResultList();
            for (Sale sale : sales) {
                Hibernate.initialize(sale.getProductsSold());
            }
            return sales;
        });
    }

    public void saveSaleWithProducts(Sale sale, List<SaleProduct> saleProducts) {
        TransactionDBUtil.execute(em -> {
            Sale mergedSale = em.merge(sale);
            for (SaleProduct saleProduct : saleProducts) {
                saleProduct.setSale(mergedSale);
                saleProduct.setProduct(em.merge(saleProduct.getProduct()));
                em.merge(saleProduct);
            }
        });
    }

    public List<Sale> filterSalesByDate(Date startDate, Date endDate) {
        return TransactionDBUtil.executeWithoutTransaction(
            em -> em.createQuery("FROM Sale WHERE saleDate BETWEEN :startDate AND :endDate", Sale.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList());
    }

    public List<Sale> filterSalesByCategory(Category category) {
        return TransactionDBUtil.executeWithoutTransaction(
            em -> em.createQuery("SELECT s FROM Sale s JOIN s.productsSold p WHERE p.product.category = :category", Sale.class)
                    .setParameter("category", category)
                    .getResultList());
    }

    public List<Sale> filterSalesByProductName(String productName) {
        return TransactionDBUtil.executeWithoutTransaction(
            em -> em.createQuery("SELECT s FROM Sale s JOIN s.productsSold p WHERE p.product.name LIKE :productName", Sale.class)
                    .setParameter("productName", "%" + productName + "%")
                    .getResultList());
    }
}
