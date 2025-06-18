package com.salescontrol;

import com.salescontrol.data.product.ProductDao;
import com.salescontrol.data.product.ProductTableModel;
import com.salescontrol.data.sale.SaleDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import com.salescontrol.domain.Product;
import com.salescontrol.domain.Sale;
import com.salescontrol.domain.SaleProduct;
import com.salescontrol.domain.User;
import com.salescontrol.enuns.UserType;
import com.salescontrol.utils.DataManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;

/**
 * Classe para a tela de registro de venda.
 * <p>
 * Esta classe estende JFrame e fornece a interface gráfica para o registro de
 * vendas. Permite adicionar produtos ao carrinho, calcular o valor total da
 * venda e finalizar a venda. Também permite navegar para outras telas como
 * registro de produto, edição de produto e relatório de vendas.
 * </p>
 */
public class RegisterSale extends javax.swing.JFrame {

    /**
     * Mapa de IDs de produtos e suas quantidades.
     */
    private Map<Integer, Integer> productIdMap = new HashMap<>();
    /**
     * Usuário atual que está utilizando a tela de registro de venda.
     */
    private final User currentUser;

    /**
     * Construtor para inicializar a tela de registro de venda com o usuário
     * atual.
     *
     * @param user o usuário atual.
     */
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

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sale-logo.png"))); // NOI18N

        scrollPaneProductsTable.setToolTipText("");
        scrollPaneProductsTable.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N

        tblProducts.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
        tblProducts.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nome", "Categoria", "Preço Unitário (R$)", "Unidade de Medida", "Quantidade"}
        ) {
            Class[] columnTypes = new Class [] {
                Integer.class, String.class, String.class, Double.class, String.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPaneProductsTable.setViewportView(tblProducts);

        txtProductQuantity.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
        txtProductQuantity.setToolTipText("Campo para preencher com a quantidade do produto selecionado para adicionar ao carrinho");
        txtProductQuantity.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bitstream Charter", 0, 14))); // NOI18N

        btnAddProductToCart.setBackground(new java.awt.Color(225, 234, 246));
        btnAddProductToCart.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        btnAddProductToCart.setText("Adicionar");
        btnAddProductToCart.setToolTipText("Botão para adicionar uma quantidade de produto ao carrinho");
        btnAddProductToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductToCartActionPerformed(evt);
            }
        });

        scrollPaneCartProducts.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N

        tblCart.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
        tblCart.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Nome", "Categoria", "Quantidade", "Preço Unitário (R$)", "Unidade de Medida"}
        ) {
            Class[] columnTypes = new Class[] {
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
        }
    );
    scrollPaneCartProducts.setViewportView(tblCart);

    lblProductsTitle.setFont(new java.awt.Font("Bitstream Charter", 1, 36)); // NOI18N
    lblProductsTitle.setText("Produtos");

    lblCartTitle.setFont(new java.awt.Font("Bitstream Charter", 1, 36)); // NOI18N
    lblCartTitle.setText("Carrinho");

    btnFinalizeSale.setBackground(new java.awt.Color(112, 199, 112));
    btnFinalizeSale.setFont(new java.awt.Font("Bitstream Charter", 0, 30)); // NOI18N
    btnFinalizeSale.setText("Finalizar");
    btnFinalizeSale.setToolTipText("Botão para finalizar venda");
    btnFinalizeSale.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFinalizeSaleActionPerformed(evt);
        }
    });

    btnClearCart.setFont(new java.awt.Font("Bitstream Charter", 0, 24)); // NOI18N
    btnClearCart.setText("Limpar carrinho");
    btnClearCart.setToolTipText("Botão para cancelar ");
    btnClearCart.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnClearCartActionPerformed(evt);
        }
    });

    btnRemoveSelectedItemFromCartTable.setBackground(new java.awt.Color(255, 102, 102));
    btnRemoveSelectedItemFromCartTable.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnRemoveSelectedItemFromCartTable.setText("Remover prouduto do carrinho");
    btnRemoveSelectedItemFromCartTable.setToolTipText("Boto para remover produto selecionado do carrinho~");
    btnRemoveSelectedItemFromCartTable.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveSelectedItemFromCartTableActionPerformed(evt);
        }
    });

    lblTotalCartValue.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

    btnCalculateTotal.setBackground(new java.awt.Color(225, 234, 246));
    btnCalculateTotal.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnCalculateTotal.setText("Calcular valor total");
    btnCalculateTotal.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCalculateTotalActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pnlRegistrationSaleLayout = new javax.swing.GroupLayout(pnlRegistrationSale);
    pnlRegistrationSale.setLayout(pnlRegistrationSaleLayout);
    pnlRegistrationSaleLayout.setHorizontalGroup(
        pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
            .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRegistrationSaleLayout.createSequentialGroup()
                    .addGap(304, 304, 304)
                    .addComponent(lblProductsTitle)
                    .addGap(166, 166, 166)
                    .addComponent(lblLogo)
                    .addGap(170, 170, 170)
                    .addComponent(lblCartTitle)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                    .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalCartValue, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                                    .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrationSaleLayout.createSequentialGroup()
                                    .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnClearCart)
                                        .addComponent(scrollPaneProductsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)))
                            .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPaneCartProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                                    .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCalculateTotal)
                                        .addComponent(btnFinalizeSale, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(217, 217, 217)
                                    .addComponent(btnRemoveSelectedItemFromCartTable)))))
                    .addGap(63, 63, 63)))
            .addContainerGap(6, Short.MAX_VALUE))
        .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
            .addGap(337, 337, 337)
            .addComponent(btnAddProductToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pnlRegistrationSaleLayout.setVerticalGroup(
        pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
            .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                    .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(lblLogo)
                            .addGap(38, 38, 38))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrationSaleLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblCartTitle)
                            .addGap(59, 59, 59)))
                    .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPaneProductsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(scrollPaneCartProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGroup(pnlRegistrationSaleLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(lblProductsTitle)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnRemoveSelectedItemFromCartTable)
                .addComponent(txtProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCalculateTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(13, 13, 13)
            .addComponent(btnAddProductToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTotalCartValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(9, 9, 9)
            .addGroup(pnlRegistrationSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnClearCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnFinalizeSale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(139, 139, 139))
    );

    menuBar.setBackground(new java.awt.Color(255, 255, 255));

    menu.setText("Menu");
    menu.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N

    itRegisterProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itRegisterProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itRegisterProduct.setText("Cadastrar Produto");
    itRegisterProduct.setToolTipText("Opção para navegar até a tela de registrar produto");
    itRegisterProduct.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itRegisterProductActionPerformed(evt);
        }
    });
    menu.add(itRegisterProduct);

    itEditProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itEditProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itEditProduct.setText("Editar Produto");
    itEditProduct.setToolTipText("Opção para navegar até a tela de editar produto");
    itEditProduct.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itEditProductActionPerformed(evt);
        }
    });
    menu.add(itEditProduct);

    itSalesReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itSalesReport.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itSalesReport.setText("Relatório de Vendas");
    itSalesReport.setToolTipText("Opção para navegar até a tela de relatório de vendas");
    itSalesReport.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            itSalesReportActionPerformed(evt);
        }
    });
    menu.add(itSalesReport);

    itLeave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itLeave.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
    itLeave.setText("Sair");
    itLeave.setToolTipText("Opção para efetuar logout");
    itLeave.addActionListener(new java.awt.event.ActionListener() {
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
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnlRegistrationSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(pnlRegistrationSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do item de menu para registrar um produto.
     * <p>
     * Abre a tela de registro de produto.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void itRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itRegisterProductActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterProduct(currentUser).setVisible(true);
        });
        this.setVisible(false);
    }//GEN-LAST:event_itRegisterProductActionPerformed

    /**
     * Ação do item de menu para editar um produto.
     * <p>
     * Abre a tela de edição de produto.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void itEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itEditProductActionPerformed
        EditProduct editProductScreen = new EditProduct(currentUser);
        editProductScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_itEditProductActionPerformed

    /**
     * Ação do item de menu para visualizar o relatório de vendas.
     * <p>
     * Abre a tela de relatório de vendas.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void itSalesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSalesReportActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new SalesReport(currentUser).setVisible(true);
        });
        this.setVisible(false);
    }//GEN-LAST:event_itSalesReportActionPerformed

    /**
     * Ação do item de menu para sair.
     * <p>
     * Abre uma caixa de diálogo de confirmação de logout.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void itLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itLeaveActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");

        int response = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Logout", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            java.awt.EventQueue.invokeLater(() -> {
                new Login().setVisible(true);
            });
            this.setVisible(false);
        }
    }//GEN-LAST:event_itLeaveActionPerformed

    /**
     * Ação do botão para adicionar produto ao carrinho.
     * <p>
     * Adiciona o produto selecionado ao carrinho, atualiza a quantidade no
     * banco de dados e exibe uma mensagem de confirmação.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnAddProductToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductToCartActionPerformed
        int[] selectedRows = tblProducts.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto para adicionar ao carrinho.");
            return;
        } else if (selectedRows.length > 1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione apenas um produto para adicionar ao carrinho.");
            return;
        }

        int selectedRow = selectedRows[0];

        String quantityText = txtProductQuantity.getText();
        txtProductQuantity.setText("");
        if (quantityText.isEmpty() || quantityText.equals("0")) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma quantidade válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A quantidade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Object productIdObject = tblProducts.getValueAt(selectedRow, 0);

            int productId = Integer.parseInt(productIdObject.toString());
            ProductDao productDao = new ProductDao();
            Product product = productDao.getProductById(productId);

            if (product != null) {
                if (quantity > product.getQuantity()) {
                    JOptionPane.showMessageDialog(this, "A quantidade inserida é maior do que a quantidade disponível em estoque.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                product.setQuantity(product.getQuantity() - quantity);
                productDao.update(product);

                DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
                cartModel.addRow(new Object[]{product.getId(), product.getName(), product.getCategory().getTranslation(), quantity, product.getUnitPrice(), product.getUnitOfMeasure().getTranslation()});

                loadProductTable();

                DataManager.getInstance().addToTemporaryCart(productId, quantity);

                JOptionPane.showMessageDialog(this, "Produto adicionado ao carrinho!");
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassCastException e) {
            System.out.println("Erro de ClassCastException ao obter o ID do produto: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar produto ao carrinho: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddProductToCartActionPerformed

    /**
     * Ação do botão para finalizar a venda.
     * <p>
     * Finaliza a venda, salvando os produtos vendidos no banco de dados e
     * exibindo uma mensagem de confirmação.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnFinalizeSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizeSaleActionPerformed
        DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "O carrinho está vazio. Adicione produtos antes de finalizar a venda.");
            return;
        }

        List<SaleProduct> saleProducts = new ArrayList<>();
        ProductDao productDao = new ProductDao();
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            Object productIdObject = cartModel.getValueAt(i, 0);
            int productId = Integer.parseInt(productIdObject.toString());

            Object quantityObject = cartModel.getValueAt(i, 3);
            int quantity = Integer.parseInt(quantityObject.toString());

            Object unitPriceObject = cartModel.getValueAt(i, 4);
            double unitPrice = Double.parseDouble(unitPriceObject.toString());

            Product product = productDao.getProductById(productId);

            SaleProduct saleProduct = new SaleProduct(product, quantity, unitPrice);
            saleProducts.add(saleProduct);
        }

        SaleDao saleDao = new SaleDao();
        Sale sale = new Sale();
        sale.setSaleDate(new Date());

        double total = 0.0;
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            Object quantityObject = cartModel.getValueAt(i, 3);
            int quantity = Integer.parseInt(quantityObject.toString());
            Object unitPriceObject = cartModel.getValueAt(i, 4);
            double unitPrice = Double.parseDouble(unitPriceObject.toString());
            total += quantity * unitPrice;
        }

        sale.setTotalValue(total);

        try {
            saleDao.save(sale, saleProducts);
            System.out.println("Venda salva com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao salvar venda: " + e.getMessage());
        }

        cartModel.setRowCount(0);
        loadProductTable();

        JOptionPane.showMessageDialog(this, "Venda finalizada com sucesso!");
    }//GEN-LAST:event_btnFinalizeSaleActionPerformed

    /**
     * Ação do botão para limpar o carrinho.
     * <p>
     * Limpa todos os produtos do carrinho e atualiza as quantidades no banco de
     * dados.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnClearCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCartActionPerformed
        DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
        ProductDao productDao = new ProductDao();
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            Object productIdObject = cartModel.getValueAt(i, 0);
            int productId = Integer.parseInt(productIdObject.toString());

            Object quantityObject = cartModel.getValueAt(i, 3);
            int quantity = Integer.parseInt(quantityObject.toString());

            Product product = productDao.getProductById(productId);
            if (product != null) {
                product.setQuantity(product.getQuantity() + quantity);
                productDao.update(product);
            }
        }
        cartModel.setRowCount(0);

        loadProductTable();

        JOptionPane.showMessageDialog(this, "Carrinho limpo!");
    }//GEN-LAST:event_btnClearCartActionPerformed

    /**
     * Ação do botão para remover o item selecionado do carrinho.
     * <p>
     * Remove o produto selecionado do carrinho e atualiza a quantidade no banco
     * de dados.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnRemoveSelectedItemFromCartTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedItemFromCartTableActionPerformed
        int selectedRow = tblCart.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto para remover do carrinho.");
            return;
        }

        DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
        Object productIdObject = cartModel.getValueAt(selectedRow, 0);
        int productId = Integer.parseInt(productIdObject.toString());

        Object quantityObject = cartModel.getValueAt(selectedRow, 3);
        int quantity = Integer.parseInt(quantityObject.toString());

        ProductDao productDao = new ProductDao();
        Product product = productDao.getProductById(productId);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            productDao.update(product);

            cartModel.removeRow(selectedRow);

            loadProductTable();

            JOptionPane.showMessageDialog(this, "Produto removido do carrinho!");
        }
    }//GEN-LAST:event_btnRemoveSelectedItemFromCartTableActionPerformed

    /**
     * Ação do botão para calcular o valor total do carrinho.
     * <p>
     * Calcula o valor total dos produtos no carrinho e exibe o resultado.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnCalculateTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateTotalActionPerformed
        DefaultTableModel cartModel = (DefaultTableModel) tblCart.getModel();
        double total = 0.0;
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            Object quantityObject = cartModel.getValueAt(i, 3);
            int quantity = Integer.parseInt(quantityObject.toString());

            Object unitPriceObject = cartModel.getValueAt(i, 4);
            double unitPrice = Double.parseDouble(unitPriceObject.toString());

            total += quantity * unitPrice;
        }
        lblTotalCartValue.setText("Valor Total: R$ " + String.format("%.2f", total));
    }//GEN-LAST:event_btnCalculateTotalActionPerformed

    /**
     * Ponto de entrada principal da aplicação.
     *
     * @param args argumentos da linha de comando.
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterSale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
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

    /**
     * Atualiza a tabela de produtos.
     * <p>
     * Carrega os dados dos produtos do banco de dados e os exibe na tabela.
     * </p>
     */
    public void updateProductTable() {
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        model.setRowCount(0);

        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAllProducts();

        productIdMap.clear();
        int rowIndex = 0;
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
            productIdMap.put(rowIndex, product.getId());
            rowIndex++;
        }
    }

    @Override
    public void setVisible(boolean b) {
        if (!b) {
            ProductDao productDao = new ProductDao();
            Map<Integer, Integer> temporaryCart = DataManager.getInstance().getTemporaryCart();

            for (Map.Entry<Integer, Integer> entry : temporaryCart.entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();

                Product product = productDao.getProductById(productId);
                if (product != null) {
                    product.setQuantity(product.getQuantity() + quantity);
                    productDao.update(product);
                }
            }

            DataManager.getInstance().clearTemporaryCart();
        }
        super.setVisible(b);
        if (b) {
            updateProductTable();
        }
    }

    /**
     * Define as permissões de acesso aos itens do menu com base no tipo de
     * usuário.
     * <p>
     * Este método desabilita certos itens do menu para usuários do tipo
     * empregado.
     * </p>
     */
    private void setPermissions() {
        if (currentUser.getUserType() == UserType.EMPLOYEE) {
            itRegisterProduct.setEnabled(false);
            itEditProduct.setEnabled(false);
            itSalesReport.setEnabled(false);
        }
    }

    /**
     * Carrega a tabela de produtos.
     * <p>
     * Este método obtém todos os produtos do banco de dados e atualiza a tabela
     * de produtos.
     * </p>
     */
    private void loadProductTable() {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getAllProducts();

        SwingUtilities.invokeLater(() -> {
            ProductTableModel productTableModel = new ProductTableModel(productList);
            tblProducts.setModel(productTableModel);
        });
    }
}
