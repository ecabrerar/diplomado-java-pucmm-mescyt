/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.maraton;

import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class MaratonApp {
     public void ejecutar() {
        menu();
        capturarTeclado();
    }

    private void menu() {
        System.out.println("=====MaratonApp=====");
        System.out.println("\n");
        System.out.println("Menu:");
    }

    private void capturarTeclado() {
         System.out.println("\n");

        try (Scanner sc = new Scanner(System.in)) {

            boolean ejecutar = true;
            while (ejecutar) {

                System.out.println("Fruta:");
                String fruta = sc.next();

                //TODO: Agregar codigo capturar

                System.out.println("Continuar ? (s/n)");

                ejecutar = esFinalizacion(sc);
            }
        }
    }
    
     /**
     *
     * Obliga que el usuario digite las letras s o n para salir o continuar la
     * ejecucion Cuando no digita una de las opciones validas continua pidiendo
     * valores por el teclado hasta que una opcion valida sea digitada. En este
     * ejemplo hacemos uso del metodo esFinalizacion(Scanner scanner) de forma
     * recursiva
     *
     * @param scanner
     * @return
     */
    private boolean esFinalizacion(Scanner scanner) {
        String opcion = scanner.next();
        System.out.println();

        boolean esEjecutar;

        if ("n".equalsIgnoreCase(opcion)) {
            esEjecutar = false;
        } else if ("s".equalsIgnoreCase(opcion)) {
            esEjecutar = true;
        } else {
            System.out.println(String.format("Opción digitada: '%s', no es válida !!", opcion));
            System.out.println("Continuar ? (s/n)");
            esEjecutar = esFinalizacion(scanner);
        }

        return esEjecutar;
    }

}
