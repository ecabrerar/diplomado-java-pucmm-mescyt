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
public class VariablesPorValor {
       public static void procesar(int j){
       
        System.out.println("iniciado procesar : j = " + j);  // 10
       
        
        j = 33;
       
        System.out.println("final de procesar : j = " + j);  // 33
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         int i = 10;
       
        
        System.out.println("main : i = " + i);  //10
             
        procesar(i );
       
        
        System.out.println("final método main: i = " + i);  // 10
        
        
    }
}
