/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gvp.database;
/**
 * MySql factory have getConnection method.
 * @return It returns MySqlConnection class's reference.
 * @author Ravirajsinh Vaghela
 *
 */
public class MySqlFactory  implements ConnectionFactory
{
    public IConnection getConnection()
    {
        return new MySqlConnection();
    }

}
