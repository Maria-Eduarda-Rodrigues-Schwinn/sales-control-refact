package com.salescontrol.utils;

import com.salescontrol.domain.Product;
import com.salescontrol.domain.Sale;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {

  private static DataManager instance;

  private List<Product> products;

  private List<Sale> sales;

  private Map<Integer, Integer> temporaryCart;

  private DataManager() {
    products = new ArrayList<>();
    sales = new ArrayList<>();
    temporaryCart = new HashMap<>();
  }

  public static DataManager getInstance() {
    if (instance == null) {
      instance = new DataManager();
    }
    return instance;
  }

  public Map<Integer, Integer> getTemporaryCart() {
    return temporaryCart;
  }

  public void addToTemporaryCart(int productId, int quantity) {
    temporaryCart.put(productId, temporaryCart.getOrDefault(productId, 0) + quantity);
  }

  public void clearTemporaryCart() {
    temporaryCart.clear();
  }

  public void removeFromTemporaryCart(int productId) {
    temporaryCart.remove(productId);
  }
}
