/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.diseno_inicial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Cliente {

    private String nombre;
    private String telefono;
    private final List<Alquiler> alquileres;

    public Cliente() {
        alquileres = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void addAquiler(Alquiler alquiler) {
        this.alquileres.add(alquiler);
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public String getFactura() {
        StringBuilder sb = new StringBuilder(100);

        double importe = 0;
        double total = 0;
        int puntos = 0;

        for (Alquiler alq : alquileres) {

            switch (alq.getDvd().getTipo()) {
                case 1:
                    importe += 70;

                    if (alq.getTiempo() > 2) {
                        importe += (alq.getTiempo() - 2) * 5;
                    }

                    break;
                case 2:

                    importe += 60;

                    if (alq.getTiempo() > 3) {
                        importe += (alq.getTiempo() - 3) * 5;
                    }

                    break;
                case 3:
                    importe += alq.getTiempo() * 80;
                    break;

                default:
                    break;
            }

            sb.append("Titulo pelicula :").append(alq.getDvd().getTitulo());
            sb.append("Importe :").append(importe);
            sb.append("\n");

            if (alq.getDvd().getTipo() == 3) {
                if (alq.getTiempo() > 1) {
                    puntos++;
                }
            }

            total += importe;

        }

        sb.append(" Total:").append(total);
        sb.append("Puntos :").append(puntos);

        return sb.toString();
    }

}
