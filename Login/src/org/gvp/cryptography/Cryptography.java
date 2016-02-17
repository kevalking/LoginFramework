/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gvp.cryptography;

import java.io.UnsupportedEncodingException;

/**
 * This Class contains Cryptography related Methods.
 * @author Keval A. Pithva
 * @since JDK 1.7
 */
public class Cryptography {
 
    private Strategy st;
    /**
     * It Constructs Cryptography class using AES,DES,RAS or any other Strategy
     * @param st Strategy Object
     */
    public Cryptography(Strategy st)
    {
        this.st=st;
    }
    /**
     * It provides message to be converted in cipher text
     * @param msg String that will be encrypted
     * @return It returns encrypted array of bytes
     * @throws UnsupportedEncodingException It will throw exception in cryptography
     */
    public byte[] getEncrypted(String msg)throws UnsupportedEncodingException
    {
       return st.getEncrypted(msg);
    }
    /**
     * This method decrypt the cipher text
     * @param b array of bytes
     * @return It returns decrypted message
     */
    public String getDecrypted(byte[] b)
    {
        return st.getDecrypted(b);
    }
}
