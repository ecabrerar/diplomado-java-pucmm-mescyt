/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class RemovedorImpares {

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Edificio","Casa","Escuela","Apartamento","Carro", "Tienda","Farmacia");
        
        List<String> listaModificable = new LinkedList<>(lista);
      
        List<String> impares = new ArrayList<>();
    
        for (String palabra : listaModificable) {
            
            if (isImpar(palabra)) {                              
                impares.add(palabra);              
               
            }
        }
        
        listaModificable.removeAll(impares);
        presentar(listaModificable);        
        
    }

    public static boolean isImpar(String palabra) {
        boolean esImpar = false;

        if (palabra.length() % 2 != 0) {
            esImpar = true;
        }

        return esImpar;
    }
    
    public static void presentar(List<String> lista){
        for (String palabra : lista) {
            System.out.println(palabra);            
            System.out.println("\n");
        }
    }
}
