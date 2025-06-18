package com.salescontrol.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária para criptografia de strings usando o algoritmo MD5.
 * <p>
 * Esta classe fornece um método para gerar o hash MD5 de uma string de entrada.
 * </p>
 */
public class Criptografia {

    /**
     * Gera um hash MD5 para a string fornecida.
     *
     * @param input a string de entrada.
     * @return o hash MD5 da string de entrada.
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
