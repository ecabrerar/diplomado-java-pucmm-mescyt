/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso5;

/**
 *
 * @author ecabrerar
 */
public class Alquiler {

    private DVD dvd;
    private int tiempo;
    private int puntos;

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPuntos() {

        if (TipoPelicula.NOVEDAD.equals(getDvd().getTipo().NOVEDAD)
                && getTiempo() > 1) {
            puntos++;
        }
        return puntos;
    }
    
    public double getImporte(){
       return dvd.getImporte(tiempo);
    }        
            

}
