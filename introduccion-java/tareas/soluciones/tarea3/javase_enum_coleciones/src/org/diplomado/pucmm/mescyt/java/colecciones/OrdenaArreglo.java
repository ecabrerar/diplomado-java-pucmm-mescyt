/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.colecciones;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author eudriscabrera
 */
public class OrdenaArreglo {

    public static void main(String[] args) {
        Integer [] enteros = {10,20,50,100,75,35};   
        
        Collections.sort(Arrays.asList(enteros));
        Collections.reverse(Arrays.asList(enteros));
        
        for (Integer entero : enteros) {
            System.out.println(" "+entero);
        }
    }
}
