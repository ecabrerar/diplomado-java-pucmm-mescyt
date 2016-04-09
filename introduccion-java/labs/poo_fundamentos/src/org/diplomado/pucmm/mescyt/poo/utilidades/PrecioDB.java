/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.poo.utilidades;

import org.diplomado.pucmm.mescyt.poo.Marca;

/**
 *
 * @author ecabrerar
 */
public class PrecioDB {

    public static double getPrecio(Marca marca) {
        switch (marca) {
            case MOTOROLA:
                return 3500;
            case SAMSUNG:
                return 4000;
            case HTC:
                return 1500;
            case LG:
                return 3000;
            default:
                return 0;
        }
    }

}
