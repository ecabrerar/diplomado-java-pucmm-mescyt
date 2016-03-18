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
public class DiaDeLaSemana {
    public static void main(String[] args) {
         // Declarar e inicializar un arreglo de caracteres con los días de la semana
        String[] dias = {"Domingo", "Lunes", "Martes", "Miércoles",
             "Jueves", "Viernes", "Sábado"};

        // Mostrar días de la semana utilizando while
        System.out.println("Mostrar días de la semana utilizando while");
        int contador = 0;
        while (contador < dias.length) {
            System.out.println(dias[contador]);
            contador++;
        }

        // Mostrar días de la semana utilizando bucle do-while
        System.out.println("Mostrar días de la semana utilizando bucle do-while");
        contador = 0;
        do {
            System.out.println(dias[contador]);
            contador++;
        } while (contador < dias.length);

        // Mostrar días de la semana utilizando para bucle
        System.out.println("Mostrar días de la semana utilizando  bucle 'for'");
        for (contador = 0; contador < dias.length; contador++) {
            System.out.println(dias[contador]);
        }
    }
}
