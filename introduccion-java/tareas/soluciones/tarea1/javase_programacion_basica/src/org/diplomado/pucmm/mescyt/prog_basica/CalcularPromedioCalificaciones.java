/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.prog_basica;

import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class CalcularPromedioCalificaciones {
     public static void main(String[] args) {
       
        System.out.println("Por favor, introduzca resultados de las pruebas que van desde 0 a 100.");
        System.out.println("Para finalizar el programa ingresar un valor mayor a 100 .");
        System.out.println();  //imprimir una linea en blanco

        //Crear un objeto de la clase Scanner llamado sc e initializar variables
        double scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        Scanner sc = new Scanner(System.in);

        //Obtener una serie de resultados de las pruebas por parte del usuario
        while (testScore <= 100) {
            // obtener la informacion del usuario
            System.out.print("Registre la puntuacion: ");
            testScore = sc.nextInt();

            // cuenta los puntos acomulados y la puntuacion total
            if (testScore <= 100) {
                scoreCount = scoreCount + 1;
                scoreTotal = scoreTotal + testScore;
            }
        }

        // mostrar el numero de puntuacion, la puntuacion total, y la puntuacion media
        double averageScore = scoreTotal / scoreCount;
        String message = "\n"
                + "Cantidad de muestra:   " + scoreCount + "\n"
                + "puntuacion total:   " + scoreTotal + "\n"
                + "puntuacion media: " + averageScore + "\n";
        System.out.println(message);
    }
}
