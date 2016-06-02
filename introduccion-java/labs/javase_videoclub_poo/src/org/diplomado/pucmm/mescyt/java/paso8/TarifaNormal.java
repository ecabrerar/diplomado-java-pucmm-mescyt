/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso8;

/**
 *
 * @author ecabrerar
 */
public class TarifaNormal extends Tarifa {

    @Override
    public TipoPelicula getTipo() {
        return TipoPelicula.NORMAL;
    }

    @Override
    public double getImporte(int tiempo) {
        double importe = 70;

        if (tiempo > 2) {
            importe += (tiempo - 2) * 5;
        }
        return importe;
    }

}
