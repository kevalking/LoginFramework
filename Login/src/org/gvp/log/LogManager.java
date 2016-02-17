/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gvp.log;

import java.io.PrintStream;
import java.util.Date;

/**
 * This package contains Log Related Classes and Methods - LogManager
 * @author Keval A. Pithva
 * @since JDK 1.7
 */
public class LogManager {
 
    private java.io.PrintStream m_out;
    private static LogManager single=new LogManager(System.out);
  
    /**
     * State contains INFO, WARNING , ERROR 
     */
     
     
    public enum State { INFO, WARNING, ERROR};
    Date d =new Date();
    /**
     * It create a PrintStream out - Private
     * @param out 
     */
    private LogManager(PrintStream out) {
        m_out=out;
    }
    /**
     * It print Log on Console Screen
     * @param msg - String that will print
     */
    public void log(String msg)
    {
        m_out.println(d.toString() +"\t"+msg);
    }
    /**
     * It print Log on Console Screen
     * @param msg - String that will print
     * @param st - State that use to indicate the Status
     */
    public void log(String msg,State st)
    {
        m_out.println(d.toString() +"\t"+st.toString()+"\t"+msg);
    }
    
     
    /**
     * It create Singleton LogManager Instance 
     * @return It returns LogManager Instance
     */
    public static LogManager getInstance()
    {
        
        
        return single;
    }
    
     
}
