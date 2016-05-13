/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.colecciones;

/**
 *
 * @author ecabrerar
 */
public class CalculaPromedio {

    public static void main(String[] args) {
        Integer​[] notas = {75, 60, 50, 100, 75, 90, 80, 85, 70, 95, 88};

        System.out.println(String.format(" Cantidad de muestras: %d", notas.length));
        System.out.println(String.format(" Puntuación total: %.2f", sumarPuntuacion(notas)));
        System.out.println(String.format(" Puntuación Promedio: %.2f", calcularPromedio(notas)));
    }

    public static double sumarPuntuacion(Integer​[] notas) {

        double total = 0;

        for (Integer nota : notas) {
            total += nota;
        }

        return total;
    }

    /**
     * Promedio = sumatoria de todas muestras / cantidad de muestras
     *
     * @param notas
     * @return
     */
    public static double calcularPromedio(Integer​[] notas) {
        return sumarPuntuacion(notas) / notas.length;
    }
}
