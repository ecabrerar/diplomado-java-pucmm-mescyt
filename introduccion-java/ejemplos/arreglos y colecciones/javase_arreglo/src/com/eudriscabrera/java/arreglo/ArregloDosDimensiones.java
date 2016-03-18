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
public class ArregloDosDimensiones {
    public static void main(String[] args) {
        // Declarar y crear un arreglo de entero de dos dimensiones  cuyo tamaño es de 10 por 5
        int[][] edades = new int[10][5];
       
        // Muestra el número de filas y columnas
        System.out.println("edades.length = " + edades.length);
        System.out.println("edades[1].length = " + edades[1].length);
       
        // Mostrar el valor de cada entrada en la matriz
        for( int i=0; i<edades.length; i++ ){
             System.out.println("\nFila " + i);
            for( int j=0; j<edades[i].length; j++ ){
                edades[i][j] = i * j;
                System.out.print( edades[i][j] + " " );
            }
        }
    }
 
}
