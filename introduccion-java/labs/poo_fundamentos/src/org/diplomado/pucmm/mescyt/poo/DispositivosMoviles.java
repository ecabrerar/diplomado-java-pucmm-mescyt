/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.poo;

/**
 *
 * @author ecabrerar
 */
public class DispositivosMoviles {
    private String nombre;
    private Marca marca;
    private String modelo;

    public DispositivosMoviles(String nombre, Marca marca, String modelo) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
