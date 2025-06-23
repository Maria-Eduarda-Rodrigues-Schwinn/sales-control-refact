package com.salescontrol.ui;

import static com.salescontrol.ui.manager.ScreenManager.showFrame;
import static com.salescontrol.ui.manager.ScreenManager.showLogin;
import static com.salescontrol.ui.manager.ScreenType.EDIT_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.REGISTER_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.REGISTER_SALE;
import static com.salescontrol.ui.manager.ScreenType.SALES_REPORT;

import com.salescontrol.domain.User;
import com.salescontrol.enuns.UserType;

public class MainMenu extends javax.swing.JFrame {

  private final User currentUser;

  public MainMenu(User user) {
    this.currentUser = user;
    initComponents();
    setPermissions();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlMainMenu = new javax.swing.JPanel();
    btnRegisterProduct = new javax.swing.JButton();
    lblLogo = new javax.swing.JLabel();
    btnEditProduct = new javax.swing.JButton();
    btnRegisterSale = new javax.swing.JButton();
    btnSalesReport = new javax.swing.JButton();
    btnLeave = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Menu");

    pnlMainMenu.setBackground(new java.awt.Color(196, 211, 231));

    btnRegisterProduct.setBackground(new java.awt.Color(225, 234, 246));
    btnRegisterProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
    btnRegisterProduct.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/box.png"))); // NOI18N
    btnRegisterProduct.setText("Cadastrar Produto");
    btnRegisterProduct.setToolTipText("Botão para registrar produto");
    btnRegisterProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRegisterProductActionPerformed(evt);
          }
        });

    lblLogo.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

    btnEditProduct.setBackground(new java.awt.Color(225, 234, 246));
    btnEditProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
    btnEditProduct.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
    btnEditProduct.setText("Editar Produto");
    btnEditProduct.setToolTipText("Botão para editar produto");
    btnEditProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditProductActionPerformed(evt);
          }
        });

    btnRegisterSale.setBackground(new java.awt.Color(225, 234, 246));
    btnRegisterSale.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
    btnRegisterSale.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/sale.png"))); // NOI18N
    btnRegisterSale.setText("Registrar Venda");
    btnRegisterSale.setToolTipText("Botão para registrar venda");
    btnRegisterSale.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRegisterSaleActionPerformed(evt);
          }
        });

    btnSalesReport.setBackground(new java.awt.Color(225, 234, 246));
    btnSalesReport.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
    btnSalesReport.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
    btnSalesReport.setText("Relatório de vendas");
    btnSalesReport.setToolTipText("Botão para abrir o relatório de vendas");
    btnSalesReport.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSalesReportActionPerformed(evt);
          }
        });

    btnLeave.setBackground(new java.awt.Color(225, 234, 246));
    btnLeave.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    btnLeave.setText("Sair");
    btnLeave.setToolTipText("Botão para efetuar logout");
    btnLeave.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLeaveActionPerformed(evt);
          }
        });

    var pnlMainMenuLayout = new javax.swing.GroupLayout(pnlMainMenu);
    pnlMainMenu.setLayout(pnlMainMenuLayout);
    pnlMainMenuLayout.setHorizontalGroup(
        pnlMainMenuLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlMainMenuLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlMainMenuLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                pnlMainMenuLayout
                                    .createSequentialGroup()
                                    .addGap(218, 218, 218)
                                    .addComponent(lblLogo))
                            .addGroup(
                                pnlMainMenuLayout
                                    .createSequentialGroup()
                                    .addGap(176, 176, 176)
                                    .addComponent(btnRegisterSale))
                            .addGroup(
                                pnlMainMenuLayout
                                    .createSequentialGroup()
                                    .addGap(163, 163, 163)
                                    .addComponent(btnRegisterProduct))
                            .addGroup(
                                pnlMainMenuLayout
                                    .createSequentialGroup()
                                    .addGap(188, 188, 188)
                                    .addComponent(btnEditProduct))
                            .addGroup(
                                pnlMainMenuLayout
                                    .createSequentialGroup()
                                    .addGap(154, 154, 154)
                                    .addComponent(btnSalesReport))
                            .addGroup(
                                pnlMainMenuLayout
                                    .createSequentialGroup()
                                    .addGap(261, 261, 261)
                                    .addComponent(btnLeave)))
                    .addContainerGap(133, Short.MAX_VALUE)));
    pnlMainMenuLayout.setVerticalGroup(
        pnlMainMenuLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlMainMenuLayout
                    .createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(lblLogo)
                    .addGap(51, 51, 51)
                    .addComponent(btnRegisterSale)
                    .addGap(18, 18, 18)
                    .addComponent(
                        btnRegisterProduct,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        60,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        btnEditProduct,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        60,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnSalesReport)
                    .addGap(37, 37, 37)
                    .addComponent(
                        btnLeave,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        40,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)));

    var layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        pnlMainMenu,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                pnlMainMenu,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnRegisterSaleActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(REGISTER_SALE, currentUser, this);
  }

  private void btnRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(REGISTER_PRODUCT, currentUser, this);
  }

  private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(EDIT_PRODUCT, currentUser, this);
  }

  private void btnSalesReportActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(SALES_REPORT, currentUser, this);
  }

  private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt) {
    showLogin(this);
  }

  public static void main(String args[]) {
    try {
      for (var info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainMenu.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(
        () -> {
          new MainMenu(new User()).setVisible(true);
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEditProduct;
  private javax.swing.JButton btnLeave;
  private javax.swing.JButton btnRegisterProduct;
  private javax.swing.JButton btnRegisterSale;
  private javax.swing.JButton btnSalesReport;
  private javax.swing.JLabel lblLogo;
  private javax.swing.JPanel pnlMainMenu;

  // End of variables declaration//GEN-END:variables

  private void setPermissions() {
    if (currentUser.getUserType() == UserType.EMPLOYEE) {
      btnEditProduct.setEnabled(false);
      btnRegisterProduct.setEnabled(false);
      btnSalesReport.setEnabled(false);
    }
  }
}
