/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.maraton;

import java.util.Objects;

/**
 *
 * @author ecabrerar
 */
public class Corredor {
    
    private final String nombre;
    private final int edad;
    private final double tiempoCarrera;

    public Corredor(String nombre, int edad, double tiempoCarrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.tiempoCarrera = tiempoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getTiempoCarrera() {
        return tiempoCarrera;
    }

    @Override
    public String toString() {       
      final  StringBuilder str = new StringBuilder(45)
                .append("Nombre:").append(nombre)
                .append("\n")
                .append("Edad:").append(edad)
                .append("\n")
                .append("Tiempo:").append(tiempoCarrera);
        
        return str.toString();
    }
    
    
    
}
