package com.salescontrol.data.user;

import com.salescontrol.data.JPAUtil;
import com.salescontrol.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

/**
 * DAO para a entidade User.
 * <p>
 * Esta classe fornece métodos para realizar operações de autenticação em
 * objetos de usuário no banco de dados. Utiliza o EntityManager para gerenciar
 * as transações.
 * </p>
 */
public class UserDao {

    /**
     * Autentica um usuário com base no login e senha fornecidos.
     *
     * @param login o login do usuário.
     * @param password a senha do usuário.
     * @return o usuário autenticado, ou null se não encontrado.
     */
    public User authenticate(String login, String password) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password", User.class);
            query.setParameter("login", login);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println("Erro na autenticação: " + e.getMessage());
            return null;
        }
    }
}
