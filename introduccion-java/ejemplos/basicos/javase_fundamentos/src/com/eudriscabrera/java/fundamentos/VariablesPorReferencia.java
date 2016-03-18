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
public class VariablesPorReferencia {
        public static void main(String[] args) {
        System.out.println("main: iniciar");
       
        
        int [] edades = {10, 11, 12};
       
        // Salida:
        // 10, 11, 12
        for (int i=0; i<edades.length; i++ ){
            System.out.println(edades[i]);
        }
       
        System.out.println("main: antes de llamar método procesar");
       
       
        procesar(edades);
       
        System.out.println("main: después de llamar método procesar");
       
        //debe imprimir nuevos valores
        for (int i=0; i<edades.length; i++ ){
            System.out.println(edades[i]);
        }
       
        System.out.println("main: iniciado");
        
    }
    
    
    public static void procesar(int[] arreglo){
       
        System.out.println("procesar: inicia");
       
        
        for (int i=0; i<arreglo.length; i++ ){
            arreglo[i] = i + 50;
        }
       
        System.out.println("procesar: final");
    }
}
