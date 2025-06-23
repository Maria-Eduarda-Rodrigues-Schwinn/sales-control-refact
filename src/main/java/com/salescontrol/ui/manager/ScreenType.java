package com.salescontrol.ui.manager;

import com.salescontrol.domain.User;
import com.salescontrol.ui.EditProduct;
import com.salescontrol.ui.Login;
import com.salescontrol.ui.MainMenu;
import com.salescontrol.ui.RegisterProduct;
import com.salescontrol.ui.RegisterSale;
import com.salescontrol.ui.SalesReport;
import javax.swing.JFrame;

public enum ScreenType {
  LOGIN(user -> new Login()),
  MAIN_MENU(MainMenu::new),
  EDIT_PRODUCT(EditProduct::new),
  REGISTER_PRODUCT(RegisterProduct::new),
  REGISTER_SALE(RegisterSale::new),
  SALES_REPORT(SalesReport::new);

  private final ScreenBuilder builder;

  ScreenType(ScreenBuilder builder) {
    this.builder = builder;
  }

  public JFrame build(User user) {
    return builder.build(user);
  }
}
