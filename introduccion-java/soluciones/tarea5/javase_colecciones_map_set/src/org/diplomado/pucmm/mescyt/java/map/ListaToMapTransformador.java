/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.diplomado.pucmm.mescyt.java.encapsulados.Genero;
import org.diplomado.pucmm.mescyt.java.encapsulados.Persona;

/**
 *
 * @author ecabrerar
 */
public class ListaToMapTransformador {

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Rita", "Perez", Genero.FEMENINO, 15));
        personas.add(new Persona("Maria", "Rosa", Genero.FEMENINO, 25));
        personas.add(new Persona("Luz", "Santos", Genero.FEMENINO, 30));
        personas.add(new Persona("Juan", "Perez", Genero.MASCULINO, 55));
        personas.add(new Persona("Victor", "Martinez", Genero.MASCULINO, 32));
        personas.add(new Persona("Rafael", "Santos", Genero.MASCULINO, 47));
        personas.add(new Persona("Manuel", "Cabral", Genero.MASCULINO, 0));
        personas.add(new Persona("Marta", "Rodriguez", Genero.FEMENINO, 18));
        personas.add(new Persona("Andres", "Jimenez", Genero.MASCULINO, 52));
        personas.add(new Persona("Hector", "Perez", Genero.MASCULINO, 51));
        
        Map<String, Persona> mapPersonas = convertirListToMap(personas);
        
        for (Map.Entry<String, Persona> entrySet : mapPersonas.entrySet()) {
            String llave = entrySet.getKey();
            Persona valor = entrySet.getValue();
            
            System.out.println(String.format("llave : %s \n valor:",llave));
            valor.printPersona();
            System.out.println("\n");
        }
    }

    /**
     * Convertir los elementos de la lista a un Map, donde la llave (key) es la concatenación de la 
     * posición del elemento dentro de la lista y el nombre y apellido.
     * @param personas
     * @return 
     */
    public static Map<String, Persona> convertirListToMap(List<Persona> personas) {

        
        Map<String, Persona> mapPersonas = new HashMap<String, Persona>();

        for (int i =0; i < personas.size();i++) {

            Persona  p = personas.get(i);
            
            String llave = String.format("%d%s%s", i,p.getNombre(),p.getApellido());
            mapPersonas.put(llave, p);
        }

        return mapPersonas;
    }
}
