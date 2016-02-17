/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gvp.database;

import java.sql.Connection;

/**
 * Application Class have connect method. and Application constructor contains one oerameter ConnectionFactory
 * @author Ravirajsinh Vaghela
 *
 */
public class Application
{
    private ConnectionFactory connectionFactory=null;
   
    public Application(ConnectionFactory connectionFactory)
    {
        this.connectionFactory=connectionFactory;
    }
    /**
     * connect method returns connection object
     * @author Ravirajsinh Vaghela
     *
 */
    public Connection connect(String Server_ip,String db_name, String user_name, String password)
    {
        IConnection con = connectionFactory.getConnection();
        return con.getConnection(Server_ip,db_name,user_name,password);
       
    }
}
