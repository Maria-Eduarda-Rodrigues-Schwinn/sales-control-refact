package com.salescontrol.utils;

import com.salescontrol.domain.Product;
import com.salescontrol.domain.Sale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por gerenciar dados da aplicação.
 * <p>
 * Esta classe implementa o padrão Singleton para garantir que apenas uma
 * instância de DataManager exista. Gerencia produtos, vendas e um carrinho
 * temporário.
 * </p>
 */
public class DataManager {

    /**
     * Instância única da classe DataManager.
     */
    private static DataManager instance;
    /**
     * Lista de produtos gerenciados pela aplicação.
     */
    private List<Product> products;
    /**
     * Lista de vendas gerenciadas pela aplicação.
     */
    private List<Sale> sales;
    /**
     * Carrinho temporário para armazenar produtos antes da finalização da
     * venda.
     */
    private Map<Integer, Integer> temporaryCart;

    /**
     * Construtor privado para inicializar o DataManager.
     * <p>
     * Inicializa as listas de produtos, vendas e o carrinho temporário.
     * </p>
     */
    private DataManager() {
        products = new ArrayList<>();
        sales = new ArrayList<>();
        temporaryCart = new HashMap<>();
    }

    /**
     * Obtém a instância única de DataManager.
     *
     * @return a instância de DataManager.
     */
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * Obtém o carrinho temporário.
     *
     * @return o mapa do carrinho temporário.
     */
    public Map<Integer, Integer> getTemporaryCart() {
        return temporaryCart;
    }

    /**
     * Adiciona um produto ao carrinho temporário.
     * <p>
     * Se o produto já estiver no carrinho, a quantidade é atualizada.
     * </p>
     *
     * @param productId o ID do produto.
     * @param quantity a quantidade do produto.
     */
    public void addToTemporaryCart(int productId, int quantity) {
        temporaryCart.put(productId, temporaryCart.getOrDefault(productId, 0) + quantity);
    }

    /**
     * Limpa o carrinho temporário.
     * <p>
     * Remove todos os produtos do carrinho temporário.
     * </p>
     */
    public void clearTemporaryCart() {
        temporaryCart.clear();
    }
}
