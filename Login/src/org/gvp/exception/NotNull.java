    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gvp.exception;

/**
 *NotNull class provides NotNull constraint.
 *
 */
public class NotNull extends Chain
    {
        public NotNull(int flag)
        {
            this.flag=flag;
        }
        public String writeMessage()
        {
            return "Error : Field can't be empty..";
        }
    }
