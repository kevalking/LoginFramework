/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gvp.cryptography;

import java.io.UnsupportedEncodingException;

/**
 * This Class contains Ronrivest Adi Sameer Encyption Methods - RSA
 * @author Keval A. Pithva
 * @since JDK 1.7
 */
public class RSA implements Strategy
{
   /* @Override
    public byte[] getEncrypted(String msg) throws UnsupportedEncodingException {
       
        byte[] b=new byte[10];
        System.out.println("RSA");
        return b;
    }
     @Override
    public String getDecrypted(byte[] b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    @Override
    public byte[] getEncrypted(String msg) throws UnsupportedEncodingException
    {
        
       msg.replaceAll(msg.intern(), msg);
       
      // System.out.println(msg);
       
       return msg.getBytes();
        
    }
    @Override
    public String getDecrypted(byte[] b) {
       
         String s=convert(b);
         s.replaceAll(s.intern(), s);
         
         return s;
        
    }
    
     private String convert(byte[] b)
    {
        StringBuilder s=new StringBuilder(b.length);
        for(int i=0;i<b.length;++i)
        {
            if(b[i]<0)throw new IllegalArgumentException();
            s.append((char)b[i]);
        }
        return s.toString();
    }
}
