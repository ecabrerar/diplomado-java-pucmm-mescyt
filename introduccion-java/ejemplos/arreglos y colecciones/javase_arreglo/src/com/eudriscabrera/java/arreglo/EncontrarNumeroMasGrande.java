/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eudriscabrera.java.arreglo;

import javax.swing.JOptionPane;

/**
 *
 * @author ecabrerar
 */
public class EncontrarNumeroMasGrande {
    public static void main(String[] args) {
          int[] numero = new int[10];
        int contador;
        int max = 0;
        int totalnumero = 3;
       
        // Solicitar que el usuario para introducir números
        for(contador = 0; contador < totalnumero; contador++){
           
            numero[contador] = Integer.parseInt
                    (JOptionPane.showInputDialog("Puedes introducir hasta "+ totalnumero+" números " ));
           
            // Calcule el mayor número hasta este punto
            if((contador == 0)||(numero[contador] > max))
                max = numero[contador];
        }
       
         //Mostrar el número más grande.
        JOptionPane.showMessageDialog(null,"El número con el valor más grande es " + max);
    }
}
