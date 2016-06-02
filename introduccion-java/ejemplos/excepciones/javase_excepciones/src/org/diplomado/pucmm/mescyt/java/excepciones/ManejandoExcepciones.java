/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class ManejandoExcepciones {

    public void excepcionesIOCatch() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("javase.txt"))) {
            long lineCount = reader.lines().count();
            System.out.println("Numero de lineas = " + lineCount);
        } catch (IOException ex) {
            Logger.getLogger(ManejandoExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excepcionesIOThrows() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("javase.txt"))) {
            long lineCount = reader.lines().count();
            System.out.println("Numero de lineas = " + lineCount);
        } 
    }
    
    public void excepcionesArrgelo(String... valores) throws ClaseExcepcion{
        
        if(valores.length==0){
             throw new ClaseExcepcion(ClaseExcepcion.DEBE_CONTENER_VALORES);
        }else {
            String primerVal = valores[0]; 
        }        
    }
    
    public static void main(String[] args) {
        try {
            ManejandoExcepciones me = new ManejandoExcepciones();
            me.excepcionesArrgelo("ejemplo");
        } catch (ClaseExcepcion ex) {
            Logger.getLogger(ManejandoExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
