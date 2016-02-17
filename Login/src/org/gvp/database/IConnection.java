package org.gvp.database;
import java.sql.*;
/**
 * This package is used for create connection and contains classes as follows..
 * @author Ravirajsinh Vaghela
 *
 */
public interface  IConnection
{
    /**
     * <u><b>getConnection</b></u> method returns the connection object of either mysql database or sql database.<br>
     * This method have 4 arguments and all are compulsory.<br>
     * <ol>
     *  <li>Server Ip (e.g. Localhost,192.168.200.171){String}</li>
     *   <li>Database Name{String}</li>
     *   <li>User Name{String}</li>
     *  <li>Password{String}</li>
     * </ol>
     * @return It returns Connection Object
     */
    public Connection getConnection(String Server_ip,String db_name,String user_name,String password);
}
