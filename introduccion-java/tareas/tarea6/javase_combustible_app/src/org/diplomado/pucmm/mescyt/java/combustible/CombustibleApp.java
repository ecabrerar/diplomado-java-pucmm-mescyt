package org.diplomado.pucmm.mescyt.java.combustible;

import org.diplomado.pucmm.mescyt.java.combustible.util.CombustibleDB;
import java.util.List;
import java.util.Scanner;

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

        // Listar items hasta que la eleccion no sea igual a "y" o "Y"
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // Obtener el tipo de combustible digitado por el usuario
            System.out.print("Escriba el tipo combustible:   ");
            String tipo = sc.next();

            List<Combustible> combustibles = CombustibleDB.getPrecio();

            combustibles.forEach((Combustible t) -> {
                System.out.println(String.format("Descripcion:   %s \n  ", t.getDescripcion()));
                System.out.println(String.format("Precio:   %.2f \n  ", t.getPrecio()));
            });

            // Si el usuario quiere seguir
            System.out.print("Continuar ? (y/n): ");
            choice = sc.next();
            System.out.println();
        }

    }

}
