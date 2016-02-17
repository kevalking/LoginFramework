package org.gvp.database;

import java.sql.*;
/**
 * SqlConnection class have getConnection method.
 * @return It returns Connection object.
 * @author Ravirajsinh Vaghela
 *
 */
public class SqlConnection implements IConnection
{

    public Connection getConnection(String Server_ip, String db_name, String user_name, String password)
    {
        Connection con=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://"+Server_ip+";databaseName="+db_name,user_name,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }

  

}
