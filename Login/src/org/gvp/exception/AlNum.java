/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.gvp.exception;

/**
 *AlNum class provides AlphaNumeric constraint.
 *
 */
public class AlNum extends Chain
    {
        public AlNum(int flag)
        {
            this.flag=flag;
        }
        public String writeMessage()
        {
            return "Error : Password must be AlphaNumeric..";
        }
    }

