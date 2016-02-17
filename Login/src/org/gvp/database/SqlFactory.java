/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gvp.database;

/**
 * Sql factory have getConnection method.
 * @return It returns SqlConnection class's reference.
 * @author Ravirajsinh Vaghela
 *
 */
public class SqlFactory  implements ConnectionFactory
{
    public IConnection getConnection()
    {
        return new SqlConnection();
    }

}

