/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java;

import org.diplomado.pucmm.mescyt.java.servicios.ConeccionDB;
import java.sql.Connection;

/**
 *
 * @author ecabrerar
 */
public class PruebaConeccion {
    public static void main(String[] args) {
        Connection coneccion = ConeccionDB.getInstancia().getConeccion();
        
        if(coneccion==null){
            System.out.println("Error !!");
        } else {
            
            System.out.println("Funciona !!");
        }
    }
}
