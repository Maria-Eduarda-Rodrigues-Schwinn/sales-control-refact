package com.salescontrol.data.product;

import com.salescontrol.data.JPAUtil;
import com.salescontrol.domain.Product;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 * DAO para gerenciar operações de banco de dados relacionadas a produtos.
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Create, Read,
 * Update, Delete) em objetos de produto no banco de dados. Utiliza o
 * EntityManager para gerenciar as transações.
 * </p>
 */
public class ProductDao {

    /**
     * Obtém uma instância de EntityManager.
     *
     * @return uma instância de EntityManager.
     */
    private EntityManager getEntityManager() {
        return JPAUtil.getEntityManager();
    }

    /**
     * Salva um produto no banco de dados.
     *
     * @param product o produto a ser salvo.
     */
    public void save(Product product) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Obtém todos os produtos do banco de dados.
     *
     * @return uma lista de todos os produtos.
     */
    public List<Product> getAllProducts() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Product", Product.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Atualiza um produto no banco de dados.
     *
     * @param product o produto a ser atualizado.
     */
    public void update(Product product) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Exclui um produto pelo ID.
     *
     * @param id o ID do produto a ser excluído.
     * @return true se o produto foi excluído com sucesso, false caso contrário.
     */
    public boolean delete(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Product product = em.find(Product.class, id);
            if (product != null) {
                em.remove(product);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Pesquisa produtos pelo nome usando LIKE.
     *
     * @param name o nome a ser pesquisado.
     * @return uma lista de produtos que correspondem ao nome.
     */
    public List<Product> searchProductsByName(String name) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Product WHERE name LIKE :name", Product.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Obtém um produto pelo ID.
     *
     * @param id o ID do produto.
     * @return o produto correspondente ao ID, ou null se o produto não for
     * encontrado.
     */
    public Product getProductById(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Atualiza a quantidade de um produto no banco de dados.
     *
     * @param productId o ID do produto.
     * @param quantity a nova quantidade do produto.
     */
    public void updateProductQuantity(int productId, int quantity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Product product = em.find(Product.class, productId);
            if (product != null) {
                product.setQuantity(quantity);
                em.merge(product);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
