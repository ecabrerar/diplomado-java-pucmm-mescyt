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
public class TarifaInfantil extends Tarifa {

    @Override
    public TipoPelicula getTipo() {
        return TipoPelicula.INFANTIL;
    }

    @Override
    public double getImporte(int tiempo) {

        double importe = 60;

        if (tiempo > 3) {
            importe += (tiempo - 3) * 5;
        }

        return importe;
    }

}
