/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Cliente {

    private String nombre;
    private String telefono;
    private List<Alquiler> alquileres;

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

            importe = getImporte(alq);

            sb.append("Titulo pelicula :").append(alq.getDvd().getTitulo());
            sb.append("Importe :").append(importe);
            sb.append("\n");

            if (TipoPelicula.NOVEDAD.equals(alq.getDvd().getTipo().NOVEDAD)
                    && alq.getTiempo() > 1) {
                puntos++;
            }

            total += importe;

        }

        sb.append(" Total:").append(total);
        sb.append("Puntos :").append(puntos);

        return sb.toString();
    }

    private double getImporte(Alquiler alquiler) {

        double importe = 0;
        switch (alquiler.getDvd().getTipo()) {
            case NORMAL:
                importe += 70;

                if (alquiler.getTiempo() > 2) {
                    importe += (alquiler.getTiempo() - 2) * 5;
                }

                break;
            case INFANTIL:

                importe += 60;

                if (alquiler.getTiempo() > 3) {
                    importe += (alquiler.getTiempo() - 3) * 5;
                }

                break;
            case NOVEDAD:
                importe += alquiler.getTiempo() * 80;
                break;

            default:
                break;
        }
        return importe;
    }

}
