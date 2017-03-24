/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author tss
 */
import java.security.MessageDigest;
import java.util.Base64;

/**
 *
 * @author tss
 */
public class Security {

  public static String digestPassword(String plainTextPassword) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(plainTextPassword.getBytes("UTF-8"));
      byte[] passwordDigest = md.digest();
      return new String(Base64.getEncoder().encode(passwordDigest));
    } catch (Exception e) {
      throw new RuntimeException("Exception encoding password", e);
    }
  }
}
