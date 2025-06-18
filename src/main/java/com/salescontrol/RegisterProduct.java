package com.salescontrol;

import com.salescontrol.data.product.ProductDao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.salescontrol.domain.Product;
import com.salescontrol.domain.User;
import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UnitOfMeasure;
import com.salescontrol.enuns.UserType;
import com.salescontrol.utils.ValidationUtils;

/**
 * Classe para a tela registrar produtos.
 * <p>
 * Esta classe estende JFrame e fornece a interface gráfica para o registro de
 * produtos. Permite adicionar novos produtos, limpar campos e navegar para
 * outras telas como registro de venda, edição de produto e relatório de vendas.
 * </p>
 */
public class RegisterProduct extends javax.swing.JFrame {

    /**
     * Usuário atual que está utilizando a tela de registro de produtos.
     */
    private final User currentUser;

    /**
     * Construtor para inicializar a tela de registrar produtos com o usuário
     * atual.
     *
     * @param user o usuário atual.
     */
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

        lblLogoIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/product-logo.png"))); // NOI18N

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
        comboUnitOfMeasureBox.setModel(new DefaultComboBoxModel<>(getUnitOfMeasureDescriptions())
        );
        comboUnitOfMeasureBox.setToolTipText("Combo box para selecionar a unidade de medida do produto");
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
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(112, 199, 112));
        btnAddProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
        btnAddProduct.setText("Adicionar");
        btnAddProduct.setToolTipText("Botão para adicionar produto");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistrationProductLayout = new javax.swing.GroupLayout(pnlRegistrationProduct);
        pnlRegistrationProduct.setLayout(pnlRegistrationProductLayout);
        pnlRegistrationProductLayout.setHorizontalGroup(
            pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrationProductLayout.createSequentialGroup()
                .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrationProductLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName)
                            .addComponent(lblCategory)
                            .addComponent(comboCategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnitPrice)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, 123)
                        .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnitOfMeasure)
                            .addComponent(comboUnitOfMeasureBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRegistrationProductLayout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistrationProductLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(lblLogoIcon)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pnlRegistrationProductLayout.setVerticalGroup(
            pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrationProductLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblLogoIcon)
                .addGap(38, 38, 38)
                .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblUnitOfMeasure))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboUnitOfMeasureBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblUnitPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(pnlRegistrationProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setText("Menu");
        menu.setToolTipText("Menu de navegação");
        menu.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N

        itRegisterSale.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itRegisterSale.setBackground(new java.awt.Color(255, 255, 255));
        itRegisterSale.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        itRegisterSale.setText("Registrar Venda");
        itRegisterSale.setToolTipText("Opção para navegar até a tela de registrar venda");
        itRegisterSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itRegisterSaleActionPerformed(evt);
            }
        });
        menu.add(itRegisterSale);

        itEditProduct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itEditProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        itEditProduct.setText("Editar produto");
        itEditProduct.setToolTipText("Opção para navegar até a tela de editar produto");
        itEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itEditProductActionPerformed(evt);
            }
        });
        menu.add(itEditProduct);

        itSalesReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itSalesReport.setFont(new java.awt.Font("Bitstream Charter", 0, 15)); // NOI18N
        itSalesReport.setText("Relatório de vendas");
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
            .addComponent(pnlRegistrationProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegistrationProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ação do item de menu para registrar uma venda.
     * <p>
     * Abre a tela de registro de venda.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void itRegisterSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itRegisterSaleActionPerformed
        RegisterSale registerSale = new RegisterSale(currentUser);
        registerSale.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_itRegisterSaleActionPerformed

    /**
     * Ação do item de menu para editar um produto.
     * <p>
     * Abre a tela de edição de produto.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void itEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itEditProductActionPerformed
        EditProduct editProduct = new EditProduct(currentUser);
        editProduct.setVisible(true);
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
     * Ação do botão para limpar os campos de entrada.
     * <p>
     * Limpa todos os campos de entrada na tela de registro de produto.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        txtName.setText("");
        txtQuantity.setText("");
        txtUnitPrice.setText("");
        comboCategoryBox.setSelectedIndex(0);
        comboUnitOfMeasureBox.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearFieldsActionPerformed

    /**
     * Ação do botão para adicionar um novo produto.
     * <p>
     * Adiciona um novo produto com base nos dados fornecidos e exibe uma
     * mensagem de confirmação. Exibe mensagens de erro se os campos de entrada
     * estiverem vazios ou contiverem valores inválidos.
     * </p>
     *
     * @param evt o evento de ação.
     */
    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        String name = txtName.getText().trim();
        String quantityStr = txtQuantity.getText().trim();
        String unitPriceStr = txtUnitPrice.getText().trim();

        if (name.isEmpty() || quantityStr.isEmpty() || unitPriceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        double unitPrice;

        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "A quantidade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            unitPrice = Double.parseDouble(unitPriceStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O preço unitário deve ser um número decimal.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String selectedCategoryDescription = (String) comboCategoryBox.getSelectedItem();
        Category category = getCategoryFromDescription(selectedCategoryDescription);

        String selectedUnitOfMeasure = (String) comboUnitOfMeasureBox.getSelectedItem();
        UnitOfMeasure unitOfMeasure = getUnitOfMeasureFromDescription(selectedUnitOfMeasure);

        try {
            ValidationUtils.validateProductInputs(name, selectedCategoryDescription, unitPrice, selectedUnitOfMeasure, quantity);
        } catch (IllegalArgumentException e) {
            return; // Validação falhou, mensagem de erro já foi exibida.
        }

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setUnitPrice(unitPrice);
        product.setUnitOfMeasure(unitOfMeasure);
        product.setQuantity(quantity);

        ProductDao productDao = new ProductDao();
        productDao.save(product);

        JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");

        btnClearFieldsActionPerformed(evt);
    }//GEN-LAST:event_btnAddProductActionPerformed

    /**
     * Ponto de entrada principal da aplicação.
     *
     * @param args argumentos da linha de comando.
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
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

    /**
     * Obtém as descrições das categorias de produto.
     * <p>
     * Este método retorna uma lista de descrições de todas as categorias de
     * produto.
     * </p>
     *
     * @return um array de Strings com as descrições das categorias de produto.
     */
    private static String[] getCategoryDescriptions() {
        Category[] unitOfMeasure = Category.values();
        String[] descriptions = new String[unitOfMeasure.length];
        for (int i = 0; i < unitOfMeasure.length; i++) {
            descriptions[i] = unitOfMeasure[i].getTranslation();
        }
        return descriptions;
    }

    /**
     * Obtém a categoria de produto a partir da descrição.
     *
     * @param description a descrição da categoria.
     * @return a categoria correspondente à descrição ou null se não encontrado.
     */
    private Category getCategoryFromDescription(String description) {
        for (Category category : Category.values()) {
            if (category.getTranslation().equals(description)) {
                return category;
            }
        }
        return null;
    }

    /**
     * Obtém as descrições das unidades de medida.
     * <p>
     * Este método retorna uma lista de descrições de todas as unidades de
     * medida.
     * </p>
     *
     * @return um array de Strings com as descrições das unidades de medida.
     */
    private static String[] getUnitOfMeasureDescriptions() {
        UnitOfMeasure[] unitOfMeasure = UnitOfMeasure.values();
        String[] descriptions = new String[unitOfMeasure.length];
        for (int i = 0; i < unitOfMeasure.length; i++) {
            descriptions[i] = unitOfMeasure[i].getTranslation();
        }
        return descriptions;
    }

    /**
     * Obtém a unidade de medida a partir da descrição.
     * <p>
     * Este método retorna a unidade de medida correspondente à descrição
     * fornecida.
     * </p>
     *
     * @param description a descrição da unidade de medida.
     * @return a unidade de medida correspondente à descrição ou null se não
     * encontrado.
     */
    private UnitOfMeasure getUnitOfMeasureFromDescription(String description) {
        for (UnitOfMeasure unitOfMeasure : UnitOfMeasure.values()) {
            if (unitOfMeasure.getTranslation().equals(description)) {
                return unitOfMeasure;
            }
        }
        return null;
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
            itEditProduct.setEnabled(false);
            itSalesReport.setEnabled(false);
        }
    }
}
