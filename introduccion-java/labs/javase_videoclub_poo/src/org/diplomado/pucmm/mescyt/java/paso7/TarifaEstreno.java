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
public class TarifaEstreno extends Tarifa{

    @Override
    public TipoPelicula getTipo() {
       return TipoPelicula.NOVEDAD;
    }

    @Override
    public double getImporte(int tiempo) {
        return tiempo * 80;
    }
    
}
