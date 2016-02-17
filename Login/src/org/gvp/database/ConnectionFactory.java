package org.gvp.database;

/**
 * ConnectionFactory is an Interface which has common method named <br>
 * <b>IConnection getConnection();</b>
 * @author Ravirajsinh Vaghela
 *
 */
public interface  ConnectionFactory
{
    IConnection getConnection();
}
