package com.salescontrol.ui;

import static com.salescontrol.ui.manager.ScreenManager.showFrame;
import static com.salescontrol.ui.manager.ScreenManager.showLogin;
import static com.salescontrol.ui.manager.ScreenType.EDIT_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.REGISTER_PRODUCT;
import static com.salescontrol.ui.manager.ScreenType.REGISTER_SALE;

import com.salescontrol.domain.User;
import com.salescontrol.dto.SaleFilterDTO;
import com.salescontrol.enuns.Category;
import com.salescontrol.enuns.UserType;
import com.salescontrol.exception.SaleValidationException;
import com.salescontrol.service.SaleService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class SalesReport extends javax.swing.JFrame {

  private final User currentUser;

  public SalesReport(User user) {
    this.currentUser = user;
    initComponents();
    setPermissions();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    lblReportsTitle = new javax.swing.JLabel();
    lblLogo = new javax.swing.JLabel();
    comboSelectedFilterBox = new javax.swing.JComboBox<>();
    scrollPaneTable = new javax.swing.JScrollPane();
    tblOfProductsSold = new javax.swing.JTable();
    btnExport = new javax.swing.JButton();
    lblFromDate = new javax.swing.JLabel();
    txtFromDate = new javax.swing.JTextField();
    lblToDate = new javax.swing.JLabel();
    txtToDate = new javax.swing.JTextField();
    btnFilter = new javax.swing.JButton();
    txtSearchedProductName = new javax.swing.JTextField();
    btnShowAll = new javax.swing.JButton();
    menuBar = new javax.swing.JMenuBar();
    menu = new javax.swing.JMenu();
    itRegisterSale = new javax.swing.JMenuItem();
    itRegistrationProduct = new javax.swing.JMenuItem();
    itEditProduct = new javax.swing.JMenuItem();
    itLeave = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Relatório de vendas");

    jPanel1.setBackground(new java.awt.Color(196, 211, 231));

    lblReportsTitle.setFont(new java.awt.Font("Bitstream Charter", 1, 36)); // NOI18N
    lblReportsTitle.setText("Relatórios");

    lblLogo.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/images/report-logo.png"))); // NOI18N

    comboSelectedFilterBox.setBackground(new java.awt.Color(225, 234, 246));
    comboSelectedFilterBox.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    comboSelectedFilterBox.setModel(new DefaultComboBoxModel<>(getCategoryTranslations()));
    comboSelectedFilterBox.setToolTipText(
        "Combo box para selecionar o tipo de filtro, categoria ou data");

    tblOfProductsSold.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    tblOfProductsSold.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {
              "ID Venda",
              "Data da Venda",
              "Nome do Produto",
              "Preço Unitário (R$)",
              "Unidade de Medida",
              "Quantidade",
              "Valor Total"
            }) {
          Class[] columnTypes =
              new Class[] {
                Integer.class,
                Date.class,
                String.class,
                Double.class,
                String.class,
                Integer.class,
                Double.class
              };

          @Override
          public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
          }

          @Override
          public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
          }
        });
    scrollPaneTable.setViewportView(tblOfProductsSold);

    btnExport.setBackground(new java.awt.Color(225, 234, 246));
    btnExport.setFont(new java.awt.Font("Bitstream Charter", 0, 20)); // NOI18N
    btnExport.setText("Exportar");
    btnExport.setToolTipText("Botão para exportar os dados preenchidos na tabela de relatórios");
    btnExport.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExportActionPerformed(evt);
          }
        });

    lblFromDate.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblFromDate.setText("De:");

    txtFromDate.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N

    lblToDate.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    lblToDate.setText("Até:");

    txtToDate.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N

    btnFilter.setBackground(new java.awt.Color(225, 234, 246));
    btnFilter.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    btnFilter.setText("Filtrar");
    btnFilter.setToolTipText("Botão para filtrar com base nos campos preenchidos acima");
    btnFilter.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFilterActionPerformed(evt);
          }
        });

    txtSearchedProductName.setBackground(new java.awt.Color(225, 234, 246));
    txtSearchedProductName.setFont(new java.awt.Font("Bitstream Charter", 0, 18)); // NOI18N
    txtSearchedProductName.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Nome do produto",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Bitstream Charter", 0, 14))); // NOI18N

    btnShowAll.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    btnShowAll.setText("Mostrar todos");
    btnShowAll.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnShowAllActionPerformed(evt);
          }
        });

    var jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblFromDate)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        txtFromDate,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblToDate)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        txtToDate,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(176, 176, 176)
                                    .addComponent(
                                        txtSearchedProductName,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        158,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        comboSelectedFilterBox,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        177,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(264, 264, 264)
                                    .addGroup(
                                        jPanel1Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                lblReportsTitle,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                177,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblLogo)))
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(
                                        scrollPaneTable,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        641,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnExport)
                    .addGap(290, 290, 290))
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(307, 307, 307)
                    .addComponent(btnFilter)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        btnShowAll,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        178,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(56, 56, 56)));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblLogo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblReportsTitle)
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                comboSelectedFilterBox,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                txtSearchedProductName,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFromDate)
                            .addComponent(
                                txtFromDate,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                40,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblToDate)
                            .addComponent(
                                txtToDate,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                40,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        jPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                jPanel1Layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        btnFilter,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        scrollPaneTable,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        263,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(
                                        btnExport,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        45,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnShowAll))
                    .addContainerGap(50, Short.MAX_VALUE)));

    menuBar.setBackground(new java.awt.Color(255, 255, 255));

    menu.setText("Menu");
    menu.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N

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

    itRegistrationProduct.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itRegistrationProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    itRegistrationProduct.setText("Cadastrar Produto");
    itRegistrationProduct.setToolTipText("Opção para navegar até a tela de registrar produto");
    itRegistrationProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itRegistrationProductActionPerformed(evt);
          }
        });
    menu.add(itRegistrationProduct);

    itEditProduct.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    itEditProduct.setFont(new java.awt.Font("Bitstream Charter", 0, 14)); // NOI18N
    itEditProduct.setText("Editar Produto");
    itEditProduct.setToolTipText("Opção para navegar até a tela de editar produto");
    itEditProduct.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            itEditProductActionPerformed(evt);
          }
        });
    menu.add(itEditProduct);

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

    var layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                jPanel1,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {
    var dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);

    var fromDateString = txtFromDate.getText().trim();
    var toDateString = txtToDate.getText().trim();
    var searchedProductName = txtSearchedProductName.getText().trim();
    var selectedCategory = (String) comboSelectedFilterBox.getSelectedItem();

    var filter = new SaleFilterDTO();
    filter.setFromDate(fromDateString);
    filter.setToDate(toDateString);
    filter.setProductName(searchedProductName);
    filter.setCategory(selectedCategory);

    try {
      var saleService = new SaleService();
      var filteredSales = saleService.filterSales(filter);

      var model = (DefaultTableModel) tblOfProductsSold.getModel();
      model.setRowCount(0);

      for (var sale : filteredSales) {
        for (var saleProduct : sale.getProductsSold()) {
          var product = saleProduct.getProduct();
          if ((selectedCategory.equals("Todas")
                  || product.getCategory().getTranslation().equals(selectedCategory))
              && (searchedProductName.isEmpty()
                  || product.getName().toLowerCase().contains(searchedProductName.toLowerCase()))) {

            model.addRow(
                new Object[] {
                  sale.getId(),
                  sale.getSaleDate(),
                  product.getName(),
                  product.getUnitPrice(),
                  product.getUnitOfMeasure().getTranslation(),
                  saleProduct.getQuantity(),
                  sale.getTotalValue()
                });
          }
        }
      }

      if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(
            this,
            "Nenhuma venda encontrada para os critérios especificados.",
            "Sem Resultados",
            JOptionPane.INFORMATION_MESSAGE);
      }
    } catch (SaleValidationException e) {
      JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {
    var reportTableModel = (DefaultTableModel) tblOfProductsSold.getModel();

    if (reportTableModel.getRowCount() == 0) {
      JOptionPane.showMessageDialog(
          this, "Não há dados para exportar.", "Erro de Exportação", JOptionPane.ERROR_MESSAGE);
      return;
    }

    var sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    var timestamp = sdf.format(new Date());
    var fileName = "relatorios/vendas_" + timestamp + ".csv";

    var directory = new File("relatorios");
    if (!directory.exists()) {
      directory.mkdirs();
    }

    try (var csvWriter = new FileWriter(fileName)) {
      for (var i = 0; i < reportTableModel.getColumnCount(); i++) {
        csvWriter.append(reportTableModel.getColumnName(i)).append(",");
      }
      csvWriter.append("\n");

      for (var i = 0; i < reportTableModel.getRowCount(); i++) {
        for (var j = 0; j < reportTableModel.getColumnCount(); j++) {
          csvWriter.append(reportTableModel.getValueAt(i, j).toString()).append(",");
        }
        csvWriter.append("\n");
      }

      JOptionPane.showMessageDialog(
          this,
          "Dados exportados para " + fileName + " com sucesso.",
          "Exportação Concluída",
          JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException ex) {
      JOptionPane.showMessageDialog(
          this,
          "Erro ao exportar dados: " + ex.getMessage(),
          "Erro de Exportação",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private void itEditProductActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(EDIT_PRODUCT, currentUser, this);
  }

  private void itRegisterSaleActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(REGISTER_SALE, currentUser, this);
  }

  private void itRegistrationProductActionPerformed(java.awt.event.ActionEvent evt) {
    showFrame(REGISTER_PRODUCT, currentUser, this);
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

  private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {
    loadSalesData();
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
      java.util.logging.Logger.getLogger(SalesReport.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(
        () -> {
          new SalesReport(new User()).setVisible(true);
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnExport;
  private javax.swing.JButton btnFilter;
  private javax.swing.JButton btnShowAll;
  private javax.swing.JComboBox<String> comboSelectedFilterBox;
  private javax.swing.JMenuItem itEditProduct;
  private javax.swing.JMenuItem itLeave;
  private javax.swing.JMenuItem itRegisterSale;
  private javax.swing.JMenuItem itRegistrationProduct;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel lblFromDate;
  private javax.swing.JLabel lblLogo;
  private javax.swing.JLabel lblReportsTitle;
  private javax.swing.JLabel lblToDate;
  private javax.swing.JMenu menu;
  private javax.swing.JMenuBar menuBar;
  private javax.swing.JScrollPane scrollPaneTable;
  private javax.swing.JTable tblOfProductsSold;
  private javax.swing.JTextField txtFromDate;
  private javax.swing.JTextField txtSearchedProductName;
  private javax.swing.JTextField txtToDate;

  // End of variables declaration//GEN-END:variables

  private static String[] getCategoryTranslations() {
    var unitOfMeasure = Category.values();
    var descriptions = new String[unitOfMeasure.length + 1];
    descriptions[0] = "Todas";
    for (var i = 0; i < unitOfMeasure.length; i++) {
      descriptions[i + 1] = unitOfMeasure[i].getTranslation();
    }
    return descriptions;
  }

  private void loadSalesData() {
    var model = (DefaultTableModel) tblOfProductsSold.getModel();
    model.setRowCount(0);

    var saleService = new SaleService();
    var allSales = saleService.getAllSales();

    for (var sale : allSales) {
      for (var saleProduct : sale.getProductsSold()) {
        var product = saleProduct.getProduct();
        model.addRow(
            new Object[] {
              sale.getId(),
              sale.getSaleDate(),
              product.getName(),
              product.getUnitPrice(),
              product.getUnitOfMeasure().getTranslation(),
              saleProduct.getQuantity(),
              sale.getTotalValue()
            });
      }
    }

    if (model.getRowCount() == 0) {
      JOptionPane.showMessageDialog(
          this, "Nenhuma venda encontrada.", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  @Override
  public void setVisible(boolean b) {
    super.setVisible(b);
    if (b) {
      loadSalesData();
    }
  }

  private void setPermissions() {
    if (currentUser.getUserType() == UserType.EMPLOYEE) {
      itEditProduct.setEnabled(false);
      itRegistrationProduct.setEnabled(false);
    }
  }
}
