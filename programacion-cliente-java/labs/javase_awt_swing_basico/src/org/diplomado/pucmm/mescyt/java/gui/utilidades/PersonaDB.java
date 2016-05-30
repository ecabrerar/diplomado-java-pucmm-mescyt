/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui.utilidades;

import java.util.ArrayList;
import java.util.List;
import org.diplomado.pucmm.mescyt.java.encapsulados.Genero;
import org.diplomado.pucmm.mescyt.java.encapsulados.Persona;

/**
 *
 * @author ecabrerar
 */
public class PersonaDB {
    
    public static List<Persona> getPersonas(){
        
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
       
        return personas;
    }
}
