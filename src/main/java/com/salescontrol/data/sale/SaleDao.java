package com.salescontrol.data.sale;

import com.salescontrol.data.JPAUtil;
import com.salescontrol.domain.Sale;
import com.salescontrol.domain.SaleProduct;
import com.salescontrol.enuns.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

/**
 * DAO para gerenciar operações de banco de dados relacionadas a vendas.
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read,
 * Update, Delete) em objetos de venda no banco de dados. Utiliza o
 * EntityManager para gerenciar as transações.
 * </p>
 */
public class SaleDao {

    /**
     * EntityManager para gerenciar as operações de banco de dados.
     */
    EntityManager em = JPAUtil.getEntityManager();

    /**
     * Salva uma venda no banco de dados.
     *
     * @param sale a venda a ser salva.
     */
    public void save(Sale sale) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(sale);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Salva uma venda e os produtos associados no banco de dados.
     *
     * @param sale a venda a ser salva.
     * @param saleProducts a lista de produtos vendidos.
     */
    public void save(Sale sale, List<SaleProduct> saleProducts) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            sale = em.merge(sale);
            for (SaleProduct saleProduct : saleProducts) {
                saleProduct.setSale(sale);
                saleProduct.setProduct(em.merge(saleProduct.getProduct()));
                em.merge(saleProduct);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Obtém todas as vendas do banco de dados.
     *
     * @return uma lista de todas as vendas.
     */
    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Sale> query = em.createQuery("FROM Sale", Sale.class);
            sales = query.getResultList();
            // Inicializa a coleção lazy-loaded
            for (Sale sale : sales) {
                Hibernate.initialize(sale.getProductsSold());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
        return sales;
    }

    /**
     * Filtra vendas pela data.
     *
     * @param startDate a data de início.
     * @param endDate a data de término.
     * @return uma lista de vendas que correspondem ao intervalo de datas.
     */
    public List<Sale> filterSalesByDate(Date startDate, Date endDate) {
        try {
            return em.createQuery("FROM Sale WHERE saleDate BETWEEN :startDate AND :endDate", Sale.class)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Filtra vendas por categoria de produto.
     *
     * @param category a categoria do produto.
     * @return uma lista de vendas que contêm produtos da categoria
     * especificada.
     */
    public List<Sale> filterSalesByCategory(Category category) {
        try {
            return em.createQuery("SELECT s FROM Sale s JOIN s.productsSold p WHERE p.product.category = :category", Sale.class)
                    .setParameter("category", category)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Filtra vendas pelo nome do produto.
     *
     * @param productName o nome do produto.
     * @return uma lista de vendas que contêm produtos com o nome especificado.
     */
    public List<Sale> filterSalesByProductName(String productName) {
        try {
            return em.createQuery("SELECT s FROM Sale s JOIN s.productsSold p WHERE p.product.name LIKE :productName", Sale.class)
                    .setParameter("productName", "%" + productName + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
