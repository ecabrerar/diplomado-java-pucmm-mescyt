/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.poo.herencia;

/**
 *
 * @author ecabrerar
 */
public class Ford extends Carro{
   private int anio;
   private int descuentoFabricante;

    public Ford(int anio, int descuentoFabricante, int cantvelodidad, double precio, String color) {
        super(cantvelodidad, precio, color);
        this.anio = anio;
        this.descuentoFabricante = descuentoFabricante;
    }
    
    
   @Override
    public double getPrecioVenta(){
        return (super.getPrecioRegular() - descuentoFabricante);
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the descuentoFabricante
     */
    public int getDescuentoFabricante() {
        return descuentoFabricante;
    }

    /**
     * @param descuentoFabricante the descuentoFabricante to set
     */
    public void setDescuentoFabricante(int descuentoFabricante) {
        this.descuentoFabricante = descuentoFabricante;
    }

    
   
   
}
