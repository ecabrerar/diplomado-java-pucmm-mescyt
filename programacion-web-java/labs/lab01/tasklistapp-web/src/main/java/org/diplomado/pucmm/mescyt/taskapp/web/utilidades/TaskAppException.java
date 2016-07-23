/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.taskapp.web.utilidades;

/**
 *
 * @author ecabrerar
 */
public class TaskAppException extends Exception{

    public TaskAppException() {
    }

    public TaskAppException(String message) {
        super(message);
    }

    public TaskAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskAppException(Throwable cause) {
        super(cause);
    }

    public TaskAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
