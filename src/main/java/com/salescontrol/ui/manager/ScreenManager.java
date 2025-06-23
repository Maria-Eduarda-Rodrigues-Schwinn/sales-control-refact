package com.salescontrol.ui.manager;

import static com.salescontrol.ui.manager.ScreenType.LOGIN;

import com.salescontrol.domain.User;
import javax.swing.JFrame;

public class ScreenManager {
  public static void showFrame(ScreenType type, User user, JFrame currentFrame) {
    type.build(user).setVisible(true);
    if (currentFrame != null) currentFrame.dispose();
  }

  public static void showLogin(JFrame currentFrame) {
    showFrame(LOGIN, null, currentFrame);
  }
}
