package com.salescontrol.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

  public static String getMD5(String input) {
    try {
      var md = MessageDigest.getInstance("MD5");
      var messageDigest = md.digest(input.getBytes());
      var sb = new StringBuilder();
      for (var b : messageDigest) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
