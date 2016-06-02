/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.colecciones;

import java.util.Arrays;
import java.util.Collections;



import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class BuscarMaximo {
    public static void main(String[] args) {
        
         List<Integer> years = Arrays.asList(1946, 1988, 1970, 1931, 1940, 1920, 1980, 1953, 1960, 
1974, 1987);
        //Buscar el valor máximo (mayor) dentro de la lista; 
         
         Collections.sort(years);
         Collections.reverse(years);
         
          System.out.println(String.format("%d es el mayor de los números digitados", years.get(0)));
    }
    
    
}
