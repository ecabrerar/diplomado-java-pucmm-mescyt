/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso3;

/**
 *
 * @author ecabrerar
 */
public class Alquiler {
    private DVD dvd;
    private int tiempo;   

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
    
    public double getImporte(){
        return dvd.getImporte(tiempo);
    }
    
    public int getPuntos(){
        return dvd.getPuntos(tiempo);
    }
}
