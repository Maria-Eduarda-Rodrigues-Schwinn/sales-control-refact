package com.salescontrol.ui;

import static com.salescontrol.ui.manager.ScreenManager.showFrame;
import static com.salescontrol.ui.manager.ScreenManager.showLogin;
import static com.salescontrol.ui.manager.ScreenType.EDIT_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.REGISTER_SALE;
import static com.salescontrol.ui.manager.ScreenType.SALES_REPORT;

import com.salescontrol.domain.User;
import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UnitOfMeasure;
import com.salescontrol.enuns.UserType;
import com.salescontrol.exception.ProductValidationException;
import com.salescontrol.exception.ValidationException;
import com.salescontrol.service.ProductService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class RegisterProduct extends javax.swing.JFrame {

  private final User currentUser;

  public RegisterProduct(User user) {
    this.currentUser = user;
    initComponents();
    setPermissions();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlRegistrationProduct = new javax.swing.JPanel();
    lblLogoIcon = new javax.swing.JLabel();
    lblName = new javax.swing.JLabel();
    txtName = new javax.swing.JTextField();
    lblCategory = new javax.swing.JLabel();
    comboCategoryBox = new javax.swing.JComboBox<>();
    lblUnitPrice = new javax.swing.JLabel();
    txtUnitPrice = new javax.swing.JTextField();
    lblUnitOfMeasure = new javax.swing.JLabel();
    comboUnitOfMeasureBox = new javax.swing.JComboBox<>();
    lblQuantity = new javax.swing.JLabel();
    txtQuantity = new javax.swing.JTextField();
    btnClearFields = new javax.swing.JButton();
    btnAddProduct = new javax.swing.JButton();
    menuBar = new javax.swing.JMenuBar();
    menu = new javax.swing.JMenu();
    itRegisterSale = new javax.swing.JMenuItem();
    itEditProduct = new javax.swing.JMenuItem();
    itSalesReport = new javax.swing.JMenuItem();
    itLeave = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Registro de produtos");

    pnlRegistrationProduct.setBackground(new java.awt.Color(196, 211, 231));

    lblLogoIcon.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/product-logo.png"))); // NOI18N

    lblName.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblName.setText("Nome");

    txtName.setBackground(new java.awt.Color(225, 234, 246));
    txtName.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    txtName.setToolTipText("Campo para preencher o nome do produto");
    txtName.setNextFocusableComponent(comboCategoryBox);

    lblCategory.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblCategory.setText("Categoria");

    comboCategoryBox.setBackground(new java.awt.Color(225, 234, 246));
    comboCategoryBox.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    comboCategoryBox.setModel(new DefaultComboBoxModel<>(getCategoryDescriptions()));
    comboCategoryBox.setToolTipText("Combo box para selecionar a categoria do produto");
    comboCategoryBox.setNextFocusableComponent(txtUnitPrice);

    lblUnitPrice.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblUnitPrice.setText("Preço Unitário");

    txtUnitPrice.setBackground(new java.awt.Color(225, 234, 246));
    txtUnitPrice.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    txtUnitPrice.setToolTipText("Campo para preencher o preço unitário do produto");
    txtUnitPrice.setNextFocusableComponent(comboUnitOfMeasureBox);

    lblUnitOfMeasure.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblUnitOfMeasure.setText("Unidade de Medida");

    comboUnitOfMeasureBox.setBackground(new java.awt.Color(225, 234, 246));
    comboUnitOfMeasureBox.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    comboUnitOfMeasureBox.setModel(new DefaultComboBoxModel<>(getUnitOfMeasureDescriptions()));
    comboUnitOfMeasureBox.setToolTipText(
        "Combo box para selecionar a unidade de medida do produto");
    comboUnitOfMeasureBox.setNextFocusableComponent(txtQuantity);

    lblQuantity.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblQuantity.setText("Quantidade");

    txtQuantity.setBackground(new java.awt.Color(225, 234, 246));
    txtQuantity.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    txtQuantity.setToolTipText("Campo para preencher com a quantidade de produtos");
    txtQuantity.setNextFocusableComponent(btnClearFields);

    btnClearFields.setBackground(new java.awt.Color(225, 234, 246));
    btnClearFields.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    btnClearFields.setText("Limpar");
    btnClearFields.setToolTipText("Botão para limpar os campos preenchidos");
    btnClearFields.setNextFocusableComponent(btnAddProduct);
    btnClearFields.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnClearFieldsActionPerformed(evt);
          }
        });

    btnAddProduct.setBackground(new java.awt.Color(112, 199, 112));
    btnAddProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    btnAddProduct.setText("Adicionar");
    btnAddProduct.setToolTipText("Botão para adicionar produto");
    btnAddProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddProductActionPerformed(evt);
          }
        });

    var pnlRegistrationProductLayout = new javax.swing.GroupLayout(pnlRegistrationProduct);
    pnlRegistrationProduct.setLayout(pnlRegistrationProductLayout);
    pnlRegistrationProductLayout.setHorizontalGroup(
        pnlRegistrationProductLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlRegistrationProductLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlRegistrationProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                pnlRegistrationProductLayout
                                    .createSequentialGroup()
                                    .addGap(111, 111, 111)
                                    .addGroup(
                                        pnlRegistrationProductLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                txtName,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                261,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName)
                                            .addComponent(lblCategory)
                                            .addComponent(
                                                comboCategoryBox,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                261,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblUnitPrice)
                                            .addComponent(
                                                txtUnitPrice,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                261,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(123, 123, 123)
                                    .addGroup(
                                        pnlRegistrationProductLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUnitOfMeasure)
                                            .addComponent(
                                                comboUnitOfMeasureBox,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                270,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblQuantity)
                                            .addComponent(
                                                txtQuantity,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                270,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                pnlRegistrationProductLayout
                                    .createSequentialGroup()
                                    .addGap(302, 302, 302)
                                    .addComponent(
                                        btnClearFields,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(
                                        btnAddProduct,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        148,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                pnlRegistrationProductLayout
                                    .createSequentialGroup()
                                    .addGap(338, 338, 338)
                                    .addComponent(lblLogoIcon)))
                    .addContainerGap(95, Short.MAX_VALUE)));
    pnlRegistrationProductLayout.setVerticalGroup(
        pnlRegistrationProductLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlRegistrationProductLayout
                    .createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(lblLogoIcon)
                    .addGap(38, 38, 38)
                    .addGroup(
                        pnlRegistrationProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblUnitOfMeasure))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        pnlRegistrationProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtName,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                comboUnitOfMeasureBox,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        pnlRegistrationProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategory)
                            .addComponent(lblQuantity))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        pnlRegistrationProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                comboCategoryBox,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                txtQuantity,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(lblUnitPrice)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtUnitPrice,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        45,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)
                    .addGroup(
                        pnlRegistrationProductLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                btnClearFields,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                btnAddProduct,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                45,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE)));

    menuBar.setBackground(new java.awt.Color(255, 255, 255));

    menu.setBackground(new java.awt.Color(255, 255, 255));
    menu.setText("Menu");
    menu.setToolTipText("Menu de navegação");
    menu.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N

    itRegisterSale.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itRegisterSale.setBackground(new java.awt.Color(255, 255, 255));
    itRegisterSale.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itRegisterSale.setText("Registrar Venda");
    itRegisterSale.setToolTipText("Opção para navegar até a tela de registrar venda");
    itRegisterSale.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itRegisterSaleActionPerformed(evt);
          }
        });
    menu.add(itRegisterSale);

    itEditProduct.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itEditProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itEditProduct.setText("Editar produto");
    itEditProduct.setToolTipText("Opção para navegar até a tela de editar produto");
    itEditProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itEditProductActionPerformed(evt);
          }
        });
    menu.add(itEditProduct);

    itSalesReport.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itSalesReport.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itSalesReport.setText("Relatório de vendas");
    itSalesReport.setToolTipText("Opção para navegar até a tela de relatório de vendas");
    itSalesReport.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itSalesReportActionPerformed(evt);
          }
        });
    menu.add(itSalesReport);

    itLeave.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itLeave.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
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

    var layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                pnlRegistrationProduct,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                pnlRegistrationProduct,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void itRegisterSaleActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(REGISTER_SALE, currentUser, this);
  }

  private void itEditProductActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(EDIT_PRODUCT, currentUser, this);
  }

  private void itSalesReportActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(SALES_REPORT, currentUser, this);
  }

  private void itLeaveActionPerformed(java.awt.event.ActionEvent evt) {
    UIManager.put("OptionPane.yesButtonText", "Sim");
    UIManager.put("OptionPane.noButtonText", "Não");

    var response =
        JOptionPane.showConfirmDialog(this, "Deseja sair?", "Logout", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
      showLogin(this);
    }
  }

  private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {
    txtName.setText("");
    txtQuantity.setText("");
    txtUnitPrice.setText("");
    comboCategoryBox.setSelectedIndex(0);
    comboUnitOfMeasureBox.setSelectedIndex(0);
  }

  private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {
    var name = txtName.getText().trim();
    var quantityStr = txtQuantity.getText().trim();
    var unitPriceStr = txtUnitPrice.getText().trim();
    var selectedCategoryDescription = (String) comboCategoryBox.getSelectedItem();
    var selectedUnitOfMeasure = (String) comboUnitOfMeasureBox.getSelectedItem();

    var productService = new ProductService();
    try {
      productService.addProduct(
          name, quantityStr, unitPriceStr, selectedCategoryDescription, selectedUnitOfMeasure);
      JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
      btnClearFieldsActionPerformed(evt);
    } catch (ProductValidationException | ValidationException ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
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
      java.util.logging.Logger.getLogger(RegisterProduct.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(
        () -> {
          new RegisterProduct(new User()).setVisible(true);
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAddProduct;
  private javax.swing.JButton btnClearFields;
  private javax.swing.JComboBox<String> comboCategoryBox;
  private javax.swing.JComboBox<String> comboUnitOfMeasureBox;
  private javax.swing.JMenuItem itEditProduct;
  private javax.swing.JMenuItem itLeave;
  private javax.swing.JMenuItem itRegisterSale;
  private javax.swing.JMenuItem itSalesReport;
  private javax.swing.JLabel lblCategory;
  private javax.swing.JLabel lblLogoIcon;
  private javax.swing.JLabel lblName;
  private javax.swing.JLabel lblQuantity;
  private javax.swing.JLabel lblUnitOfMeasure;
  private javax.swing.JLabel lblUnitPrice;
  private javax.swing.JMenu menu;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JPanel pnlRegistrationProduct;
  private javax.swing.JTextField txtName;
  private javax.swing.JTextField txtQuantity;
  private javax.swing.JTextField txtUnitPrice;

  // End of variables declaration//GEN-END:variables

  private static String[] getCategoryDescriptions() {
    var unitOfMeasure = Category.values();
    var descriptions = new String[unitOfMeasure.length];
    for (var i = 0; i < unitOfMeasure.length; i++) {
      descriptions[i] = unitOfMeasure[i].getTranslation();
    }
    return descriptions;
  }

  private static String[] getUnitOfMeasureDescriptions() {
    var unitOfMeasure = UnitOfMeasure.values();
    var descriptions = new String[unitOfMeasure.length];
    for (var i = 0; i < unitOfMeasure.length; i++) {
      descriptions[i] = unitOfMeasure[i].getTranslation();
    }
    return descriptions;
  }

  private void setPermissions() {
    if (currentUser.getUserType() == UserType.EMPLOYEE) {
      itEditProduct.setEnabled(false);
      itSalesReport.setEnabled(false);
    }
  }
}
