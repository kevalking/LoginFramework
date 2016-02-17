/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gvp.cryptography;

import java.io.UnsupportedEncodingException;

/**
 * Strategy Interface provides types of Strategy (AES,DES,RSA)
 * @author Keval A. Pithva
 * @since JDK 1.7
 */
public interface Strategy {

    /**
     * 
     * @param args the command line arguments
     */
   public byte[] getEncrypted(String msg)throws UnsupportedEncodingException;
  public String getDecrypted(byte[] b);
}
