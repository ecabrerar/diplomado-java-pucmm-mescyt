package com.eudriscabrera.java.arreglo;

import java.util.Arrays;

public class ClaseArray {

    public static void main(String[] args) {
        /**
         * Fill method
         */

        int[] cantidades = new int[5];
        Arrays.fill(cantidades, 1); //todos los elementos fueron inicializados en 1


        /**
         * Sort Method
         */

        int[] notasAbr = { 100, 80, 90, 75, 60, 50, 70, 80, 90, 100 };
        Arrays.sort(notasAbr);


        for (int nota : notasAbr) {
            System.out.println(nota);
        }


    }
}
