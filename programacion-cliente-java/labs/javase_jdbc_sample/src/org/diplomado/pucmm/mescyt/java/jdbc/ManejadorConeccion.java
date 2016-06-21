/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class ManejadorConeccion {
    
    
    private void cargarDriver() throws ClassNotFoundException{        
        Class.forName("org.apache.derby.jdbc.ClientDriver"); //Cargando el Driver de Derby DB
    }
    
    public Connection getConeccion() throws SQLException{
        
        try {
            cargarDriver();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejadorConeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //String de coneccion
        String url = "jdbc:derby://localhost:1527/sample";
        String usuario = "app";
        String clave = "app";
        
       Connection  con = DriverManager.getConnection(url, usuario, clave);
        
        return con;
    }
}
