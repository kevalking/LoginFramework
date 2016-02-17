/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gvp.exception;

/**
 *PwdGT5 class provides password grater then 5 chars. constraint.
 *
 */
public class PwdGT5 extends Chain
    {
        public PwdGT5(int flag)
        {
            this.flag=flag;
        }
        public String writeMessage()
        {
            return "Error : Password must be more than five charecters..";
        }
    }