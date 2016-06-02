/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso3;

/**
 * Clase alquiler : <b>Ejemplo<b>
 * @author ecabrerar
 */
public class Alquiler {
    private DVD dvd;
    private int tiempo;   

    /**
     * 
     * @return 
     */
    public DVD getDvd() {
        return dvd;
    }

    /**
     * Metodo que recibe un objeto del tipo DVD
     * @param dvd 
     */
    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public double getImporte(){
        return dvd.getImporte(tiempo);
    }
    
    public int getPuntos(){
        return dvd.getPuntos(tiempo);
    }
}
