/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.colecciones;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class BuscadorPalabra {
    
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Edificio", "Casa", "Escuela", "Apartamento", "Carro", 
"Tienda","Farmacia","Supermercado","Plaza","Cine","Hotel" );  
        
        //Buscar la palabra de mayor longitud dentro de la lista
        
        System.out.println(String.format("La palabra de mayor longitud es %s",buscarPalabraMayorLongitud(lista)));
    }
    
    public static String buscarPalabraMayorLongitud(List<String> lista){
        String mayor = null;
        
        for (String palabra : lista) {
            
            if(mayor==null){
                mayor = palabra;
            }else {
                if(palabra.length() > mayor.length()){
                    mayor = palabra;
                }
            }
        }
        
        return mayor;
    }
}
