/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eudriscabrera.java.fundamentos;

/**
 *
 * @author ecabrerar
 */
public class TresTiposVariables {
     
    static String variableEstatica = "variable estatica";
   
    
    String variableInstancia = "Variable Instancia";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String variableLocal = "variable local ";
        System.out.println("estatica = " + variableEstatica);
        //System.out.println("variable instancia = " + variableInstancia);
        System.out.println("local = " + variableLocal);
        
        
    }
}
