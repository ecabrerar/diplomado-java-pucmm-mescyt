package org.diplomado.pucmm.mescyt.java.combustible;

import org.diplomado.pucmm.mescyt.java.combustible.util.CombustibleDB;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.diplomado.pucmm.mescyt.java.combustible.util.Tipo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ecabrerar
 */
public class CombustibleApp {

    public static void main(String[] args) {

        System.out.println("Bienvenido a Combustible App");
        System.out.println();  // imprimir una linea en blanco

        // crear un objeto de la clase Scanner llamado sc
        Scanner sc = new Scanner(System.in);

        boolean ejecutar = true;

        while (ejecutar) {
            // Obtener el tipo de combustible digitado por el usuario
            System.out.print("Escriba el tipo combustible:   ");
            String tipo = sc.next();

            if (Tipo.esTipoMiembro(tipo)) {
                Tipo seleccionada = Tipo.valueOf(tipo.toUpperCase());
                buscarCombustibleTipo(seleccionada);
            } else {
                System.out.println(String.format("Opción digitada: '%s', no es válida !!", tipo));
            }

            // Si el usuario quiere seguir
            System.out.print("Continuar ? (y/n): ");

            ejecutar = esFinalizacion(sc);

        }

    }

    /**
     *
     * Obliga que el usuario digite las letras y o n para salir o continuar la
     * ejecucion Cuando no digita una de las opciones validas continua pidiendo
     * valores por el teclado hasta que una opcion valida sea digitada. En este
     * ejemplo hacemos uso del metodo esFinalizacion(Scanner scanner) de forma
     * recursiva
     *
     * @param scanner
     * @return
     */
    private static boolean esFinalizacion(Scanner scanner) {
        String opcion = scanner.next();
        System.out.println();

        boolean esEjecutar;

        if ("n".equalsIgnoreCase(opcion)) {
            esEjecutar = false;
        } else if ("y".equalsIgnoreCase(opcion)) {
            esEjecutar = true;
        } else {
            System.out.println(String.format("Opción digitada: '%s', no es válida !!", opcion));
            System.out.println("Continuar ? (y/n)");
            esEjecutar = esFinalizacion(scanner);
        }

        return esEjecutar;
    }

    private static void buscarCombustibleTipo(Tipo tipo) {
        List<Combustible> combustibles = CombustibleDB.getPrecio();

        //Usando Expresiones Lambdas para filtrar el tipo de combustible
        Optional<Combustible> optCombustible = combustibles
                .stream()
                .filter((Combustible t) -> tipo.equals(t.getTipo()))
                .findFirst();

        if (optCombustible.isPresent()) {

            Combustible combustible = optCombustible.get();

            System.out.println(String.format("Descripcion:   %s \n  ", combustible.getDescripcion()));
            System.out.println(String.format("Precio:   %.2f \n  ", combustible.getPrecio()));
        }

    }

}
