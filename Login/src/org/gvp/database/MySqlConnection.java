package org.gvp.database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * MySqlConnection class have getConnection method.
 * @return It returns Connection object.
 * @author Ravirajsinh Vaghela
 *
 */
public class MySqlConnection implements org.gvp.database.IConnection
{

    public Connection getConnection(String Server_ip,String db_name, String user_name, String password)//this method is for made connection
    {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+Server_ip+"/"+db_name,user_name,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    

}
