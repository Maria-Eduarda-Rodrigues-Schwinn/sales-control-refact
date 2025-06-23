package com.salescontrol;

import com.salescontrol.ui.Login;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class App {
  public static void main(String[] args) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | IllegalAccessException
        | InstantiationException
        | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(
        () -> {
          new Login().setVisible(true);
        });
  }
}
