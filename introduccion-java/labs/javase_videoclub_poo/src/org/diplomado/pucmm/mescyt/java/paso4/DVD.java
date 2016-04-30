/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso4;

/**
 *
 * @author ecabrerar
 */
public class DVD {
    private final String titulo;
    private final TipoPelicula tipo;
    
    public DVD(String titulo, TipoPelicula tipo){
        this.titulo = titulo;
        this.tipo = tipo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public TipoPelicula getTipo(){
        return tipo;
    }
}
