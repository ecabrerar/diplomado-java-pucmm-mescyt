/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.poo.herencia;

/**
 *
 * @author ecabrerar
 */
public class Sedan extends Carro {

    private int longitud;

    public Sedan(int puertas, int cantvelocidad, double precioRegular, String color) {
        super(cantvelocidad, precioRegular, color);
        this.longitud = puertas;
    } 

   
    @Override
    public double getPrecioVenta() {
        if(getLongitud() > 20){
            return (super.getPrecioRegular() - (super.getPrecioRegular() * 0.05));
        }else{
            return (super.getPrecioRegular() - (super.getPrecioRegular() * 0.10));
        }
    }

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
