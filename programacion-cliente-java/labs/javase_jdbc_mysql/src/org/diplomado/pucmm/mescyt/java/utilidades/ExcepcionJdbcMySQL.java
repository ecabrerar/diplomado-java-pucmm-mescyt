/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.utilidades;

/**
 *
 * @author ecabrerar
 */
public class ExcepcionJdbcMySQL extends Exception{

    public ExcepcionJdbcMySQL() {
    }

    public ExcepcionJdbcMySQL(String message) {
        super(message);
    }

    public ExcepcionJdbcMySQL(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionJdbcMySQL(Throwable cause) {
        super(cause);
    }

    public ExcepcionJdbcMySQL(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
