/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.enumerados;

/**
 *
 * @author eudriscabrera
 */
public class PruebaEntrada {
   
    public static void main(String[] args) {
        for (Entrada entrada : Entrada.values()) {
            System.out.println(String.format("El precio de la entrada en %s es RD$%.2f", entrada,entrada.getPrecio()));
        }
    }
}
