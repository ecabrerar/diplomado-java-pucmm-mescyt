/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.excepciones;

/**
 *
 * @author ecabrerar
 */
public class ClaseExcepcion extends Exception{

    public static final int DEBE_CONTENER_VALORES = 1;
    private int codigo;
    
    
    @Override
    public String getMessage() {
        
        switch(codigo){
            case DEBE_CONTENER_VALORES:
                return "Valores debe contener algunos elementos";
                
            default:
                 return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
        }       
    }    

    public ClaseExcepcion(int codigo) {
        this.codigo = codigo;
    }

    public ClaseExcepcion(String message) {
        super(message);
    }

    public ClaseExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public ClaseExcepcion(Throwable cause) {
        super(cause);
    }

    public ClaseExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
