/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gvp.cryptography;

import java.io.UnsupportedEncodingException;

/**
 * This Class contains Advance Encryption Standard Methods - AES
 * @author Keval A. Pithva
 * @since JDK 1.7
 */
public class AES implements Strategy
{
    

    @Override
    public byte[] getEncrypted(String msg) throws UnsupportedEncodingException
    {
       byte[] b;
        StringBuffer s=new StringBuffer(msg);
        String rev=s.reverse().toString();
        //System.out.println(rev);
        b= rev.getBytes("US-ASCII");
       return b;
        
    }
      @Override
   public String getDecrypted(byte[] b)
    {
      String s=convert(b);
     StringBuffer sb=new StringBuffer(s);
     
      return sb.reverse().toString();
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
