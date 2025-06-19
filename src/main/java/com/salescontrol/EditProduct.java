package com.salescontrol;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.data.product.ProductTableModel;
import com.salescontrol.domain.Product;
import com.salescontrol.domain.User;
import com.salescontrol.enuns.UserType;
import com.salescontrol.exception.ProductOperationException;
import com.salescontrol.exception.ProductValidationException;
import com.salescontrol.exception.ValidationException;
import com.salescontrol.service.ProductService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class EditProduct extends javax.swing.JFrame {

  private final User currentUser;

  public EditProduct(User user) {
    this.currentUser = user;
    initComponents();
    setPermissions();

    loadProductTable();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlEditProduct = new javax.swing.JPanel();
    lblTitle = new javax.swing.JLabel();
    scrollPaneProductsTable = new javax.swing.JScrollPane();
    tblProducts = new javax.swing.JTable();
    btnEditSelectedProduct = new javax.swing.JButton();
    btnDropSelectedProduct = new javax.swing.JButton();
    btnSearchByProductName = new javax.swing.JButton();
    btnLoadAll = new javax.swing.JButton();
    menuBar = new javax.swing.JMenuBar();
    menu = new javax.swing.JMenu();
    itRegisterSale = new javax.swing.JMenuItem();
    itRegisterProduct = new javax.swing.JMenuItem();
    itSaleReports = new javax.swing.JMenuItem();
    itLeave = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Editar Produtos");

    pnlEditProduct.setBackground(new java.awt.Color(196, 211, 231));

    lblTitle.setFont(new java.awt.Font("Bitstream Charter", 1, 36)); // NOI18N
    lblTitle.setText("Produtos");

    scrollPaneProductsTable.setBackground(new java.awt.Color(225, 234, 246));

    tblProducts.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    tblProducts.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {
              "ID", "Nome", "Categoria", "Preço Unitário (R$)", "Unidade de Medida", "Quantidade"
            }));
    tblProducts.setRowHeight(30);
    scrollPaneProductsTable.setViewportView(tblProducts);

    btnEditSelectedProduct.setBackground(new java.awt.Color(225, 234, 246));
    btnEditSelectedProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    btnEditSelectedProduct.setText("Editar selecionado");
    btnEditSelectedProduct.setToolTipText("Botão para editar produto selecionado");
    btnEditSelectedProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditSelectedProductActionPerformed(evt);
          }
        });

    btnDropSelectedProduct.setBackground(new java.awt.Color(255, 102, 102));
    btnDropSelectedProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    btnDropSelectedProduct.setText("Excluir selecionado");
    btnDropSelectedProduct.setToolTipText("Botão para excluir produto selecionado");
    btnDropSelectedProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDropSelectedProductActionPerformed(evt);
          }
        });

    btnSearchByProductName.setBackground(new java.awt.Color(225, 234, 246));
    btnSearchByProductName.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnSearchByProductName.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
    btnSearchByProductName.setText("Pesquisar");
    btnSearchByProductName.setToolTipText(
        "Botão para pesquisar nome de produtos que contém o texto preenchido no campo ao lado");
    btnSearchByProductName.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchByProductNameActionPerformed(evt);
          }
        });

    btnLoadAll.setBackground(new java.awt.Color(225, 234, 246));
    btnLoadAll.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnLoadAll.setText("Mostrar todos");
    btnLoadAll.setToolTipText("Boto para limpar pesquisa e exibir todos os produtos");
    btnLoadAll.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoadAllActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout pnlEditProductLayout = new javax.swing.GroupLayout(pnlEditProduct);
    pnlEditProduct.setLayout(pnlEditProductLayout);
    pnlEditProductLayout.setHorizontalGroup(
        pnlEditProductLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlEditProductLayout
                    .createSequentialGroup()
                    .addGap(215, 215, 215)
                    .addComponent(btnDropSelectedProduct)
                    .addGap(69, 69, 69)
                    .addComponent(btnEditSelectedProduct)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                pnlEditProductLayout
                    .createSequentialGroup()
                    .addContainerGap(84, Short.MAX_VALUE)
                    .addGroup(
                        pnlEditProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                pnlEditProductLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        pnlEditProductLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                scrollPaneProductsTable,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                649,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                pnlEditProductLayout
                                                    .createSequentialGroup()
                                                    .addComponent(
                                                        btnSearchByProductName,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        217,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnLoadAll)))
                                    .addGap(84, 84, 84))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                pnlEditProductLayout
                                    .createSequentialGroup()
                                    .addComponent(lblTitle)
                                    .addGap(334, 334, 334)))));
    pnlEditProductLayout.setVerticalGroup(
        pnlEditProductLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlEditProductLayout
                    .createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(lblTitle)
                    .addGap(71, 71, 71)
                    .addGroup(
                        pnlEditProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadAll)
                            .addComponent(
                                btnSearchByProductName,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                42,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(
                        scrollPaneProductsTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        318,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)
                    .addGroup(
                        pnlEditProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                btnDropSelectedProduct,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                btnEditSelectedProduct,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(40, Short.MAX_VALUE)));

    menuBar.setBackground(new java.awt.Color(255, 255, 255));
    menuBar.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N

    menu.setText("Menu");

    itRegisterSale.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itRegisterSale.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    itRegisterSale.setText("Registrar venda");
    itRegisterSale.setToolTipText("Opção para navegar até a tela de registrar venda");
    itRegisterSale.setActionCommand("Registrar Venda");
    itRegisterSale.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itRegisterSaleActionPerformed(evt);
          }
        });
    menu.add(itRegisterSale);

    itRegisterProduct.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itRegisterProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    itRegisterProduct.setText("Cadastrar Produto");
    itRegisterProduct.setToolTipText("Opção para navegar até a tela de registrar produto");
    itRegisterProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itRegisterProductActionPerformed(evt);
          }
        });
    menu.add(itRegisterProduct);

    itSaleReports.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itSaleReports.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    itSaleReports.setText("Relatório de vendas");
    itSaleReports.setToolTipText("Opção para navegar até a tela de relatório de vendas");
    itSaleReports.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itSaleReportsActionPerformed(evt);
          }
        });
    menu.add(itSaleReports);

    itLeave.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itLeave.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    itLeave.setText("Sair");
    itLeave.setToolTipText("Opção para efetuar logout");
    itLeave.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itLeaveActionPerformed(evt);
          }
        });
    menu.add(itLeave);

    menuBar.add(menu);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                pnlEditProduct,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                pnlEditProduct,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void itRegisterSaleActionPerformed(java.awt.event.ActionEvent evt) {
    java.awt.EventQueue.invokeLater(
        () -> {
          new RegisterSale(currentUser).setVisible(true);
        });
    this.setVisible(false);
  }

  private void itRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {
    java.awt.EventQueue.invokeLater(
        () -> {
          new RegisterProduct(currentUser).setVisible(true);
        });
    this.setVisible(false);
  }

  private void itSaleReportsActionPerformed(java.awt.event.ActionEvent evt) {
    java.awt.EventQueue.invokeLater(
        () -> {
          new SalesReport(currentUser).setVisible(true);
        });
    this.setVisible(false);
  }

  private void itLeaveActionPerformed(java.awt.event.ActionEvent evt) {
    UIManager.put("OptionPane.yesButtonText", "Sim");
    UIManager.put("OptionPane.noButtonText", "Não");

    int response =
        JOptionPane.showConfirmDialog(this, "Deseja sair?", "Logout", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
      java.awt.EventQueue.invokeLater(
          () -> {
            new Login().setVisible(true);
          });
      this.setVisible(false);
    }
  }

  private void btnEditSelectedProductActionPerformed(java.awt.event.ActionEvent evt) {
    int[] selectedRows = tblProducts.getSelectedRows();
    if (selectedRows.length == 0) {
      JOptionPane.showMessageDialog(
          this, "Nenhum produto foi selecionado. Por favor, escolha um da lista para editar.");
      return;
    } else if (selectedRows.length > 1) {
      JOptionPane.showMessageDialog(this, "Por favor, selecione apenas um produto para edição.");
      return;
    }

    int selectedRow = selectedRows[0];
    int productId = (int) tblProducts.getValueAt(selectedRow, 0);
    String currentUnitPrice = tblProducts.getValueAt(selectedRow, 3).toString();
    String currentQuantity = tblProducts.getValueAt(selectedRow, 5).toString();

    String newUnitPrice =
        JOptionPane.showInputDialog(this, "Novo preço unitário do produto:", currentUnitPrice);
    String newQuantity =
        JOptionPane.showInputDialog(this, "Nova quantidade do produto:", currentQuantity);

    if (newUnitPrice != null && newQuantity != null) {
      ProductService productService = new ProductService();
      try {
        productService.updateProduct(productId, newUnitPrice, newQuantity);

        tblProducts.setValueAt(Double.valueOf(newUnitPrice), selectedRow, 3);
        tblProducts.setValueAt(Integer.valueOf(newQuantity), selectedRow, 5);

        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
        loadProductTable();
      } catch (ProductValidationException | ValidationException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void btnDropSelectedProductActionPerformed(java.awt.event.ActionEvent evt) {
    int selectedRow = tblProducts.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "Por favor, selecione um produto para excluir.");
      return;
    }

    int productId = (int) tblProducts.getValueAt(selectedRow, 0);

    UIManager.put("OptionPane.yesButtonText", "Sim");
    UIManager.put("OptionPane.noButtonText", "Não");

    int confirm =
        JOptionPane.showConfirmDialog(
            this,
            "Tem certeza de que deseja excluir o produto?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
      ProductService productService = new ProductService();
      try {
        productService.deleteProduct(productId);
        loadProductTable();
        JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
      } catch (ProductOperationException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void btnSearchByProductNameActionPerformed(java.awt.event.ActionEvent evt) {
    String searchName = JOptionPane.showInputDialog(this, "Digite o nome do produto para buscar:");
    if (searchName != null && !searchName.trim().isEmpty()) {
      ProductDao productDao = new ProductDao();
      List<Product> productList = productDao.searchProductsByName(searchName.trim());
      tblProducts.setModel(new ProductTableModel(productList));
    } else {
      JOptionPane.showMessageDialog(
          this, "Nome do produto não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void btnLoadAllActionPerformed(java.awt.event.ActionEvent evt) {
    loadProductTable();
  }

  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(EditProduct.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(
        () -> {
          new EditProduct(new User()).setVisible(true);
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnDropSelectedProduct;
  private javax.swing.JButton btnEditSelectedProduct;
  private javax.swing.JButton btnLoadAll;
  private javax.swing.JButton btnSearchByProductName;
  private javax.swing.JMenuItem itLeave;
  private javax.swing.JMenuItem itRegisterProduct;
  private javax.swing.JMenuItem itRegisterSale;
  private javax.swing.JMenuItem itSaleReports;
  private javax.swing.JLabel lblTitle;
  private javax.swing.JMenu menu;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JPanel pnlEditProduct;
  private javax.swing.JScrollPane scrollPaneProductsTable;
  private javax.swing.JTable tblProducts;

  // End of variables declaration//GEN-END:variables

  public void updateProductTable() {
    DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
    model.setRowCount(0);

    ProductService productService = new ProductService();
    List<Product> products = productService.getAllProducts();

    for (Product product : products) {
      Object[] row = {
        product.getId(),
        product.getName(),
        product.getCategory().getTranslation(),
        product.getUnitPrice(),
        product.getUnitOfMeasure().getTranslation(),
        product.getQuantity()
      };
      model.addRow(row);
    }
  }

  @Override
  public void setVisible(boolean b) {
    super.setVisible(b);
    updateProductTable();
  }

  private void setPermissions() {
    if (currentUser.getUserType() == UserType.EMPLOYEE) {
      itRegisterProduct.setEnabled(false);
      itSaleReports.setEnabled(false);
    }
  }

  private void loadProductTable() {
    ProductService productService = new ProductService();
    List<Product> productList = productService.getAllProducts();

    SwingUtilities.invokeLater(
        () -> {
          ProductTableModel productTableModel = new ProductTableModel(productList);
          tblProducts.setModel(productTableModel);
        });
  }
}
