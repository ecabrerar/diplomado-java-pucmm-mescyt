/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.enumerados;

/**
 *
 * @author ecabrerar
 */
public enum Fruta {
    MANGO,NARANJA,MELON,ZAPOTE,SANDIA;
    
    public static boolean esFrutaMiembro(String name) {
        boolean isMember = false;

        for (Fruta type : Fruta.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                isMember = true;
            }
        }
        return isMember;
    }
}


