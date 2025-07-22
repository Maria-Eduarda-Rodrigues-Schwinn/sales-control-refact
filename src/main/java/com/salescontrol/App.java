package com.salescontrol;

import static java.util.logging.Level.SEVERE;

import com.salescontrol.domain.User;
import com.salescontrol.ui.Login;
import com.salescontrol.ui.MainMenu;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
  public static void main(String[] args) {
    test();

    configurarLookAndFeel();
    iniciarAplicacao();
  }

  public static void configurarLookAndFeel() {
    try {
      for (var info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | IllegalAccessException
        | InstantiationException
        | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(App.class.getName()).log(SEVERE, null, ex);
    }
  }

  public static void iniciarAplicacao() {
    java.awt.EventQueue.invokeLater(
        () -> {
          new Login().setVisible(true);
        });
  }

  public static void test() {
    System.out.println("=== Iniciando testes ===");

    testarLookAndFeelAplicado();
    testarTelaLogin();
    testarTelaMenu();

    System.out.println("=== Fim dos testes ===");
  }

  public static void testarLookAndFeelAplicado() {
    configurarLookAndFeel();
    String atual = javax.swing.UIManager.getLookAndFeel().getName();
    System.out.println("LookAndFeel atual: " + atual);
  }

  public static void testarTelaMenu() {
    System.out.println("Testando criação da tela de Menu...");
    MainMenu menu = new MainMenu(new User());
    if (menu.isVisible() == false) {
      System.out.println("Menu criado, mas ainda não está visível.");
    }
  }

  public static void testarTelaLogin() {
    System.out.println("Testando criação de tela de login...");
    Login login = new Login();

    if (login.isVisible() == false) {
      System.out.println("Login criado, mas ainda não está visível.");
    }
  }
}
