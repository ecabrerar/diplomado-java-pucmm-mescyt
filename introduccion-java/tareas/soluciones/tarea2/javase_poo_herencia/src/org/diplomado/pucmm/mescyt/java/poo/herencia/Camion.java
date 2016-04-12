/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.poo.herencia;

/**
 *
 * @author ecabrerar
 */
public class Camion extends Carro {

    private int peso;

    public Camion(int cantvelodidad, double precio, String color, int peso) {
        super(cantvelodidad, precio, color);
        this.peso = peso;
    }

    
    @Override
    public double getPrecioVenta() {
        if (peso > 2000) {
            return (super.getPrecioRegular() - (super.getPrecioRegular() * 0.1));
        } else {
            return (super.getPrecioRegular() - (super.getPrecioRegular() * 0.2));
        }
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

 
    
    
}
