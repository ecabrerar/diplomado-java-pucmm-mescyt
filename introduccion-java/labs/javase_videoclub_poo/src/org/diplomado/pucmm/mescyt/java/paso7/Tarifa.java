/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso7;

/**
 *
 * @author ecabrerar
 */
public abstract class Tarifa {
    public abstract TipoPelicula getTipo();
     public abstract double getImporte(int tiempo);
}
