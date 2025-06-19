package com.salescontrol.data.user;

import com.salescontrol.data.TransactionDBUtil;
import com.salescontrol.domain.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDao {

  public User authenticate(String login, String password) {
    return TransactionDBUtil.executeWithoutTransaction(
        em -> {
          try {
            TypedQuery<User> query =
                em.createQuery(
                    "SELECT u FROM User u WHERE u.login = :login AND u.password = :password",
                    User.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            return query.getSingleResult();
          } catch (NoResultException e) {
            return null;
          } catch (Exception e) {
            System.out.println("Erro na autenticação: " + e.getMessage());
            return null;
          }
        });
  }
}
