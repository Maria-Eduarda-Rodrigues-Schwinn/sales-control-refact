package com.salescontrol.service;

import com.salescontrol.data.user.UserDao;
import com.salescontrol.domain.User;
import com.salescontrol.exception.InvalidCredentialsException;

public class UserService {
  private final UserDao userDao = new UserDao();

  public User authenticate(String login, String password) {
    User user = userDao.authenticate(login, password);

    if (user == null) throw new InvalidCredentialsException("Login ou senha inválidos.");

    return user;
  }
}
