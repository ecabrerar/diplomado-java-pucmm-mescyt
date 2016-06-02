/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ecabrerar
 */
public class SelectorPares {

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Edificio", "Casa", "Escuela", "Apartamento", "Carro", "Tienda", "Farmacia", "Supermercado", "Plaza", "Cine", "Hotel");

        Set<String> pares = llenarSetPares(lista);

        for (String par : pares) {
            System.out.println(par);
            System.out.println("\n");
        }

    }

    /**
     * Buscar todas las palabras que tengan longitud par y retornarla en un Set.
     * @param lista
     * @return 
     */
    public static Set<String> llenarSetPares(List<String> lista) {
        final Set<String> pares = new HashSet<String>();
        
        for (String palabra : lista) {
            if (esLogintudPar(palabra)) {
                pares.add(palabra);
            }
        }

        return pares;
    }

    public static boolean esLogintudPar(String palabra) {

        boolean esPar = false;

        if (palabra.length() % 2 == 0) {
            esPar = true;
        }

        return esPar;
    }
}
