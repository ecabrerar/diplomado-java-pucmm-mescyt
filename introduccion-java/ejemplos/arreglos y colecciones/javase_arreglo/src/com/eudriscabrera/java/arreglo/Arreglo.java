/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eudriscabrera.java.arreglo;

/**
 *
 * @author ecabrerar
 */
public class Arreglo {
    public static void main(String[] args) {
        
        //Declaracion de un arreglo de entero de tamano 10
        int[] edades = new int[10];
       
        
        for(int i=0; i < edades.length;i++){
            edades[i] = 100+i;
        }
        
        // Mostrar el valor de cada entrada en el arreglo        
        for( int i=0; i<edades.length; i++ ){
            System.out.print( edades[i]+"\n" );
        }
    }
}
