package com.salescontrol.ui.manager;

import com.salescontrol.domain.User;
import javax.swing.JFrame;

public interface ScreenBuilder {
  JFrame build(User user);
}
