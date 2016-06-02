/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ecabrerar
 */
public class ContadorRepeticionesMap {

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Edificio", "Casa", "Escuela", "Apartamento", "Edificio",
                "Tienda", "Farmacia", "Apartamento", "Plaza", "Farmacia", "Hotel");
        
     
        Map<String, Integer> repeticiones = contarRepeticiones(lista);
        
        for (Map.Entry<String, Integer> entrySet : repeticiones.entrySet()) {
            String llave = entrySet.getKey();
            Integer valor = entrySet.getValue();
            
            System.out.println(String.format("%s : %d", llave,valor));
            
        }
        
    }
    
    /**
     * Contar las veces que se repite una palabra dentro de una lista de String
     * @param lista
     * @return 
     */
    public static Map<String, Integer> contarRepeticiones(List<String> lista){
        
        Map<String, Integer> mapRepeticiones = new HashMap<>();
        
        /**
         * 
         * Si mapRepeticiones esta vacia guardo la palabra con un valor de 1, que representa
         * la vez que fue encuentrada en la lista. 
         * Si la lista contiene elementos, buscamos si el elemento ya existe,
         * en caso de existir se le suma 1 a la cantidad almacena.
         * Si no existia entonces se guarda con valor de 1.
         * 
         */
        
        for (String palabra : lista) {
            
            if(mapRepeticiones.isEmpty()){
                mapRepeticiones.put(palabra, 1);
            }else {
                if(mapRepeticiones.containsKey(palabra)){
                    mapRepeticiones.put(palabra, mapRepeticiones.get(palabra)+1);
                }else{
                    mapRepeticiones.put(palabra, 1);
                }
            }
        }
        
        return mapRepeticiones;
    }
}
