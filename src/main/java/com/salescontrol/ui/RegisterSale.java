package com.salescontrol.ui;

import static com.salescontrol.ui.manager.ScreenManager.showFrame;
import static com.salescontrol.ui.manager.ScreenManager.showLogin;
import static com.salescontrol.ui.manager.ScreenType.EDIT_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.REGISTER_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.SALES_REPORT;

import com.salescontrol.data.product.ProductTableModel;
import com.salescontrol.domain.SaleProduct;
import com.salescontrol.domain.User;
import com.salescontrol.enuns.UserType;
import com.salescontrol.exception.CartOperationException;
import com.salescontrol.exception.SaleNotFoundException;
import com.salescontrol.exception.SaleValidationException;
import com.salescontrol.exception.ValidationException;
import com.salescontrol.service.CartService;
import com.salescontrol.service.ProductService;
import com.salescontrol.service.SaleService;
import com.salescontrol.utils.DataManager;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class RegisterSale extends javax.swing.JFrame {

  private Map<Integer, Integer> productIdMap = new HashMap<>();

  private final User currentUser;

  public RegisterSale(User user) {
    this.currentUser = user;
    initComponents();
    setPermissions();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlRegistrationSale = new javax.swing.JPanel();
    lblLogo = new javax.swing.JLabel();
    scrollPaneProductsTable = new javax.swing.JScrollPane();
    tblProducts = new javax.swing.JTable();
    txtProductQuantity = new javax.swing.JTextField();
    btnAddProductToCart = new javax.swing.JButton();
    scrollPaneCartProducts = new javax.swing.JScrollPane();
    tblCart = new javax.swing.JTable();
    lblProductsTitle = new javax.swing.JLabel();
    lblCartTitle = new javax.swing.JLabel();
    btnFinalizeSale = new javax.swing.JButton();
    btnClearCart = new javax.swing.JButton();
    btnRemoveSelectedItemFromCartTable = new javax.swing.JButton();
    lblTotalCartValue = new javax.swing.JLabel();
    btnCalculateTotal = new javax.swing.JButton();
    menuBar = new javax.swing.JMenuBar();
    menu = new javax.swing.JMenu();
    itRegisterProduct = new javax.swing.JMenuItem();
    itEditProduct = new javax.swing.JMenuItem();
    itSalesReport = new javax.swing.JMenuItem();
    itLeave = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Registrar venda");

    pnlRegistrationSale.setBackground(new java.awt.Color(196, 211, 231));

    lblLogo.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/sale-logo.png"))); // NOI18N

    scrollPaneProductsTable.setToolTipText("");
    scrollPaneProductsTable.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N

    tblProducts.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    tblProducts.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {
              "ID", "Nome", "Categoria", "Preço Unitário (R$)", "Unidade de Medida", "Quantidade"
            }) {
          Class[] columnTypes =
              new Class[] {
                Integer.class, String.class, String.class, Double.class, String.class, Integer.class
              };

          public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
          }
        });
    scrollPaneProductsTable.setViewportView(tblProducts);

    txtProductQuantity.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    txtProductQuantity.setToolTipText(
        "Campo para preencher com a quantidade do produto selecionado para adicionar ao carrinho");
    txtProductQuantity.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Quantidade",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Bitstream Charter", 0, 14))); // NOI18N

    btnAddProductToCart.setBackground(new java.awt.Color(225, 234, 246));
    btnAddProductToCart.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    btnAddProductToCart.setText("Adicionar");
    btnAddProductToCart.setToolTipText(
        "Botão para adicionar uma quantidade de produto ao carrinho");
    btnAddProductToCart.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddProductToCartActionPerformed(evt);
          }
        });

    scrollPaneCartProducts.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N

    tblCart.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    tblCart.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {
              "ID", "Nome", "Categoria", "Quantidade", "Preço Unitário (R$)", "Unidade de Medida"
            }) {
          Class[] columnTypes =
              new Class[] {
                Integer.class, String.class, String.class, Double.class, String.class, Integer.class
              };

          @Override
          public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
          }

          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        });
    scrollPaneCartProducts.setViewportView(tblCart);

    lblProductsTitle.setFont(new java.awt.Font("Bitstream Charter", 1, 36)); // NOI18N
    lblProductsTitle.setText("Produtos");

    lblCartTitle.setFont(new java.awt.Font("Bitstream Charter", 1, 36)); // NOI18N
    lblCartTitle.setText("Carrinho");

    btnFinalizeSale.setBackground(new java.awt.Color(112, 199, 112));
    btnFinalizeSale.setFont(new java.awt.Font("Bitstream Charter", 0, 30)); // NOI18N
    btnFinalizeSale.setText("Finalizar");
    btnFinalizeSale.setToolTipText("Botão para finalizar venda");
    btnFinalizeSale.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFinalizeSaleActionPerformed(evt);
          }
        });

    btnClearCart.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
    btnClearCart.setText("Limpar carrinho");
    btnClearCart.setToolTipText("Botão para cancelar ");
    btnClearCart.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnClearCartActionPerformed(evt);
          }
        });

    btnRemoveSelectedItemFromCartTable.setBackground(new java.awt.Color(255, 102, 102));
    btnRemoveSelectedItemFromCartTable.setFont(
        new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnRemoveSelectedItemFromCartTable.setText("Remover prouduto do carrinho");
    btnRemoveSelectedItemFromCartTable.setToolTipText(
        "Boto para remover produto selecionado do carrinho~");
    btnRemoveSelectedItemFromCartTable.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveSelectedItemFromCartTableActionPerformed(evt);
          }
        });

    lblTotalCartValue.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

    btnCalculateTotal.setBackground(new java.awt.Color(225, 234, 246));
    btnCalculateTotal.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnCalculateTotal.setText("Calcular valor total");
    btnCalculateTotal.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCalculateTotalActionPerformed(evt);
          }
        });

    var pnlRegistrationSaleLayout = new javax.swing.GroupLayout(pnlRegistrationSale);
    pnlRegistrationSale.setLayout(pnlRegistrationSaleLayout);
    pnlRegistrationSaleLayout.setHorizontalGroup(
        pnlRegistrationSaleLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlRegistrationSaleLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlRegistrationSaleLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                pnlRegistrationSaleLayout
                                    .createSequentialGroup()
                                    .addGap(304, 304, 304)
                                    .addComponent(lblProductsTitle)
                                    .addGap(166, 166, 166)
                                    .addComponent(lblLogo)
                                    .addGap(170, 170, 170)
                                    .addComponent(lblCartTitle)
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(
                                pnlRegistrationSaleLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        pnlRegistrationSaleLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(
                                                pnlRegistrationSaleLayout
                                                    .createSequentialGroup()
                                                    .addContainerGap(
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addComponent(
                                                        lblTotalCartValue,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        289,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(
                                                pnlRegistrationSaleLayout
                                                    .createSequentialGroup()
                                                    .addGap(106, 106, 106)
                                                    .addGroup(
                                                        pnlRegistrationSaleLayout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                pnlRegistrationSaleLayout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        txtProductQuantity,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        100,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                            .addGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .TRAILING,
                                                                pnlRegistrationSaleLayout
                                                                    .createSequentialGroup()
                                                                    .addGroup(
                                                                        pnlRegistrationSaleLayout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .TRAILING,
                                                                                false)
                                                                            .addComponent(
                                                                                btnClearCart)
                                                                            .addComponent(
                                                                                scrollPaneProductsTable,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                582,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE))
                                                                    .addGap(38, 38, 38)))
                                                    .addGroup(
                                                        pnlRegistrationSaleLayout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addComponent(
                                                                scrollPaneCartProducts,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                643,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE)
                                                            .addGroup(
                                                                pnlRegistrationSaleLayout
                                                                    .createSequentialGroup()
                                                                    .addGroup(
                                                                        pnlRegistrationSaleLayout
                                                                            .createParallelGroup(
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .Alignment
                                                                                    .LEADING)
                                                                            .addComponent(
                                                                                btnCalculateTotal)
                                                                            .addComponent(
                                                                                btnFinalizeSale,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE,
                                                                                200,
                                                                                javax.swing
                                                                                    .GroupLayout
                                                                                    .PREFERRED_SIZE))
                                                                    .addGap(217, 217, 217)
                                                                    .addComponent(
                                                                        btnRemoveSelectedItemFromCartTable)))))
                                    .addGap(63, 63, 63)))
                    .addContainerGap(6, Short.MAX_VALUE))
            .addGroup(
                pnlRegistrationSaleLayout
                    .createSequentialGroup()
                    .addGap(337, 337, 337)
                    .addComponent(
                        btnAddProductToCart,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        100,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    pnlRegistrationSaleLayout.setVerticalGroup(
        pnlRegistrationSaleLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlRegistrationSaleLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlRegistrationSaleLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                pnlRegistrationSaleLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        pnlRegistrationSaleLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                pnlRegistrationSaleLayout
                                                    .createSequentialGroup()
                                                    .addGap(35, 35, 35)
                                                    .addComponent(lblLogo)
                                                    .addGap(38, 38, 38))
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                pnlRegistrationSaleLayout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(lblCartTitle)
                                                    .addGap(59, 59, 59)))
                                    .addGroup(
                                        pnlRegistrationSaleLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(
                                                scrollPaneProductsTable,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                325,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                scrollPaneCartProducts,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                0,
                                                Short.MAX_VALUE)))
                            .addGroup(
                                pnlRegistrationSaleLayout
                                    .createSequentialGroup()
                                    .addGap(152, 152, 152)
                                    .addComponent(lblProductsTitle)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        pnlRegistrationSaleLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoveSelectedItemFromCartTable)
                            .addComponent(
                                txtProductQuantity,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                btnCalculateTotal,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                35,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addComponent(
                        btnAddProductToCart,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        40,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        lblTotalCartValue,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        36,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addGroup(
                        pnlRegistrationSaleLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                btnClearCart,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                40,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                btnFinalizeSale,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                50,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(139, 139, 139)));

    menuBar.setBackground(new java.awt.Color(255, 255, 255));

    menu.setText("Menu");
    menu.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N

    itRegisterProduct.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itRegisterProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itRegisterProduct.setText("Cadastrar Produto");
    itRegisterProduct.setToolTipText("Opção para navegar até a tela de registrar produto");
    itRegisterProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itRegisterProductActionPerformed(evt);
          }
        });
    menu.add(itRegisterProduct);

    itEditProduct.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itEditProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itEditProduct.setText("Editar Produto");
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
    itSalesReport.setText("Relatório de Vendas");
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
                pnlRegistrationSale,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        pnlRegistrationSale,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void itRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(REGISTER_PRODUCT, currentUser, this);
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

  private void btnAddProductToCartActionPerformed(java.awt.event.ActionEvent evt) {
    var selectedRows = tblProducts.getSelectedRows();
    if (selectedRows.length == 0) {
      JOptionPane.showMessageDialog(
          this, "Por favor, selecione um produto para adicionar ao carrinho.");
      return;
    } else if (selectedRows.length > 1) {
      JOptionPane.showMessageDialog(this, "Por favor, selecione apenas um produto.");
      return;
    }

    var selectedRow = selectedRows[0];
    var productIdObj = tblProducts.getValueAt(selectedRow, 0);
    var productId = Integer.parseInt(productIdObj.toString());

    var quantityText = txtProductQuantity.getText().trim();
    txtProductQuantity.setText("");

    var saleService = new SaleService();
    try {
      var product = saleService.addProductToCart(productId, quantityText);

      var cartModel = (DefaultTableModel) tblCart.getModel();

      var quantityToAdd = Integer.parseInt(quantityText);

      var found = false;
      for (var i = 0; i < cartModel.getRowCount(); i++) {
        var existingProductId = Integer.parseInt(cartModel.getValueAt(i, 0).toString());
        if (existingProductId == productId) {
          var currentQuantity = Integer.parseInt(cartModel.getValueAt(i, 3).toString());
          var updatedQuantity = currentQuantity + quantityToAdd;
          cartModel.setValueAt(updatedQuantity, i, 3);
          found = true;
          break;
        }
      }

      if (!found) {
        cartModel.addRow(
            new Object[] {
              product.getId(),
              product.getName(),
              product.getCategory().getTranslation(),
              quantityToAdd,
              product.getUnitPrice(),
              product.getUnitOfMeasure().getTranslation()
            });
      }

      loadProductTable();
      DataManager.getInstance().addToTemporaryCart(productId, quantityToAdd);

      JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho!");
    } catch (SaleValidationException | SaleNotFoundException | ValidationException e) {
      JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void btnFinalizeSaleActionPerformed(java.awt.event.ActionEvent evt) {
    var cartModel = (DefaultTableModel) tblCart.getModel();
    if (cartModel.getRowCount() == 0) {
      JOptionPane.showMessageDialog(
          this, "O carrinho está vazio. Adicione produtos antes de finalizar a venda.");
      return;
    }

    List<SaleProduct> saleProducts = new ArrayList<>();
    for (var i = 0; i < cartModel.getRowCount(); i++) {
      var productId = Integer.parseInt(cartModel.getValueAt(i, 0).toString());
      var quantity = Integer.parseInt(cartModel.getValueAt(i, 3).toString());
      var unitPrice = Double.parseDouble(cartModel.getValueAt(i, 4).toString());

      var productService = new ProductService();
      var product = productService.getProductById(productId);

      var saleProduct = new SaleProduct(product, quantity, unitPrice);
      saleProducts.add(saleProduct);
    }

    var saleService = new SaleService();
    try {
      saleService.finalizeSale(saleProducts);
      cartModel.setRowCount(0);
      loadProductTable();
      DataManager.getInstance().clearTemporaryCart();
      JOptionPane.showMessageDialog(this, "Venda finalizada com sucesso!");
    } catch (HeadlessException ex) {
      JOptionPane.showMessageDialog(
          this, "Erro ao finalizar venda: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void btnClearCartActionPerformed(java.awt.event.ActionEvent evt) {
    var cartModel = (DefaultTableModel) tblCart.getModel();
    var cartService = new CartService();
    cartService.clearCart(cartModel);
    loadProductTable();
    JOptionPane.showMessageDialog(this, "Carrinho limpo!");
  }

  private void btnRemoveSelectedItemFromCartTableActionPerformed(java.awt.event.ActionEvent evt) {
    var selectedRows = tblCart.getSelectedRows();
    if (selectedRows.length == 0) {
      JOptionPane.showMessageDialog(this, "Por favor, selecione ao menos um produto para remover.");
      return;
    }

    var cartModel = (DefaultTableModel) tblCart.getModel();
    var cartService = new CartService();

    try {
      Arrays.sort(selectedRows);
      for (var i = selectedRows.length - 1; i >= 0; i--) {
        cartService.removeItemFromCart(cartModel, selectedRows[i]);
      }

      loadProductTable();
      JOptionPane.showMessageDialog(this, "Produto(s) removido(s) do carrinho!");
    } catch (CartOperationException ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void btnCalculateTotalActionPerformed(java.awt.event.ActionEvent evt) {
    var cartModel = (DefaultTableModel) tblCart.getModel();
    var total = 0.0;
    for (var i = 0; i < cartModel.getRowCount(); i++) {
      var quantityObject = cartModel.getValueAt(i, 3);
      var quantity = Integer.parseInt(quantityObject.toString());

      var unitPriceObject = cartModel.getValueAt(i, 4);
      var unitPrice = Double.parseDouble(unitPriceObject.toString());

      total += quantity * unitPrice;
    }
    lblTotalCartValue.setText("Valor Total: R$ " + String.format("%.2f", total));
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
      java.util.logging.Logger.getLogger(RegisterSale.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(
        () -> {
          new RegisterSale(new User()).setVisible(true);
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAddProductToCart;
  private javax.swing.JButton btnCalculateTotal;
  private javax.swing.JButton btnClearCart;
  private javax.swing.JButton btnFinalizeSale;
  private javax.swing.JButton btnRemoveSelectedItemFromCartTable;
  private javax.swing.JMenuItem itEditProduct;
  private javax.swing.JMenuItem itLeave;
  private javax.swing.JMenuItem itRegisterProduct;
  private javax.swing.JMenuItem itSalesReport;
  private javax.swing.JLabel lblCartTitle;
  private javax.swing.JLabel lblLogo;
  private javax.swing.JLabel lblProductsTitle;
  private javax.swing.JLabel lblTotalCartValue;
  private javax.swing.JMenu menu;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JPanel pnlRegistrationSale;
  private javax.swing.JScrollPane scrollPaneCartProducts;
  private javax.swing.JScrollPane scrollPaneProductsTable;
  private javax.swing.JTable tblCart;
  private javax.swing.JTable tblProducts;
  private javax.swing.JTextField txtProductQuantity;

  // End of variables declaration//GEN-END:variables

  public void updateProductTable() {
    var model = (DefaultTableModel) tblProducts.getModel();
    model.setRowCount(0);

    var productService = new ProductService();
    var products = productService.getAllProducts();

    productIdMap.clear();
    var rowIndex = 0;
    for (var product : products) {
      Object[] row = {
        product.getId(),
        product.getName(),
        product.getCategory().getTranslation(),
        product.getUnitPrice(),
        product.getUnitOfMeasure().getTranslation(),
        product.getQuantity()
      };
      model.addRow(row);
      productIdMap.put(rowIndex, product.getId());
      rowIndex++;
    }
  }

  @Override
  public void setVisible(boolean b) {
    if (!b) {
      var cartService = new CartService();
      cartService.restoreStockFromCart();
    }

    super.setVisible(b);

    if (b) {
      updateProductTable();
    }
  }

  private void setPermissions() {
    if (currentUser.getUserType() == UserType.EMPLOYEE) {
      itRegisterProduct.setEnabled(false);
      itEditProduct.setEnabled(false);
      itSalesReport.setEnabled(false);
    }
  }

  private void loadProductTable() {
    var productService = new ProductService();
    var productList = productService.getAllProducts();

    SwingUtilities.invokeLater(
        () -> {
          var productTableModel = new ProductTableModel(productList);
          tblProducts.setModel(productTableModel);
        });
  }
}
