/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.poo.herencia;

/**
 *
 * @author ecabrerar
 */
public class Carro {

    private int cantVelocidad;
    private double precioRegular;
    private String color;

    public Carro(int cantVelocidad, double precio, String color) {
        this.cantVelocidad = cantVelocidad;
        this.precioRegular = precio;
        this.color = color;
    }

    /**
     * @return the cantVelocidad
     */
    public int getCantVelocidad() {
        return cantVelocidad;
    }

    /**
     * @param cantVelocidad the cantVelocidad to set
     */
    public void setCantVelocidad(int cantVelocidad) {
        this.cantVelocidad = cantVelocidad;
    }

    /**
     * @return the precioRegular
     */
    public double getPrecioRegular() {
        return precioRegular;
    }

    /**
     * @param precioRegular the precioRegular to set
     */
    public void setPrecioRegular(double precioRegular) {
        this.precioRegular = precioRegular;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecioVenta() {
        return 0;
    }

}
