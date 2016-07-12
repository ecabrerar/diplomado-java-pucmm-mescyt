/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt;

/**
 *
 * @author ecabrerar
 */
public class Auto {
    
    private String modelo;
    private Marca marca;
    private int anio;
    private Color color;

    public Auto(String modelo, Marca marca, int anio, Color color) {
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
    }
    
    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return modelo;
    }
    
    
    
}
