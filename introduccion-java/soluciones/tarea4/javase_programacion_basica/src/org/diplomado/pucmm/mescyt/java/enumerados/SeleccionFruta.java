/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.enumerados;

import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class SeleccionFruta {

    public void ejecutar() {
        menu();
        capturarTeclado();
    }

    private void menu() {
        System.out.println("=====Seleccion Fruta=====");
        System.out.println("\n");
        System.out.println("Menu:");

        int cont = 1;
        for (Fruta t : Fruta.values()) {
            System.out.println(String.format(" %d %s", cont, t));
            cont++;
        }
    }

    private void capturarTeclado() {
        System.out.println("\n");

        try (Scanner sc = new Scanner(System.in)) {

            boolean ejecutar = true;
            while (ejecutar) {

                System.out.println("Fruta:");
                String fruta = sc.next();

                if (Fruta.esFrutaMiembro(fruta)) {
                    Fruta seleccionada = Fruta.valueOf(fruta.toUpperCase());
                    decirSiTeGusta(seleccionada);
                } else {
                    System.out.println(String.format("Opción digitada: '%s', no es válida !!", fruta));
                }

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

    private void decirSiTeGusta(Fruta fruta) {

        switch (fruta) {
            case MANGO:
                System.out.println("Mango es muy bueno.");
                break;
            case SANDIA:
                System.out.println("No me gusta la sandía. ");
                break;
            case NARANJA:
                System.out.println("La naranja es muy buena pero prefiero el zapote. ");
                break;
            case MELON:
                System.out.println("El melón es mi favorito. ");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SeleccionFruta menuFruta = new SeleccionFruta();
        menuFruta.ejecutar();
    }
}
