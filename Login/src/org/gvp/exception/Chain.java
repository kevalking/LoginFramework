
package org.gvp.exception;
/**
 *Chain class is abstract class.<br>
 * it has setNext method which contains one argument like setNext(Chain chain).<br>
 * Also have message method which have two arguments like message(String msg,int priority).
 *
 */
public abstract class Chain extends Exception
{
    public static int One = 1;
    public static int Two = 2;
    public static int Three = 3;
    protected int flag;
    protected Chain next;

    public void setNext(Chain chain)
    {
        next = chain;
    }
    public void message(String msg,int priority)
    {
        if(priority<=flag)
        {
            writeMessage();
        }
        if(next!=null)
        {
            next.message(msg, priority);
        }
    }
    abstract public String writeMessage();
    public void checkErr(String unm,String pass)
    {
        
    }
}

    
    
   
