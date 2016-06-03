/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.combustible.util;

/**
 *
 * @author ecabrerar
 */
public enum Tipo {
    GASOLINA,
    GASOIL,
    GLP,
    GNV,
    KEROSENE;
    
    public static boolean esTipoMiembro(String name) {
        boolean isMember = false;

        for (Tipo type : Tipo.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                isMember = true;
            }
        }
        return isMember;
    }
}
