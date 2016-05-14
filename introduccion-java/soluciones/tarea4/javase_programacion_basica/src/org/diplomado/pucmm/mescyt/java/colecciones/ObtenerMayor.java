/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class ObtenerMayor {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            boolean ejecutar = true;
            
            while (ejecutar) {
                System.out.println("Digite un número entero positivo:");
                int numero = sc.nextInt();

                numeros.add(numero);

                System.out.println("Continuar ? (s/n)");

                ejecutar = esFinalizacion(sc);
            }
        } catch (InputMismatchException imex) {
            System.out.println("El valor digitado no es un entero valido");
        }

        Collections.sort(numeros);
        Collections.reverse(numeros);

        if (numeros.isEmpty()) {
            System.out.println("El arreglo no contiene valores");
        } else {
            System.out.println(String.format("%d es el mayor de los números digitados", numeros.get(0)));
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
    public static boolean esFinalizacion(Scanner scanner) {
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
