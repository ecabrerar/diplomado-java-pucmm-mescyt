/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class ConeccionDB {
    
    private static ConeccionDB instancia=null;
    
    public static ConeccionDB getInstancia(){
        
        if(instancia==null){
            instancia = new ConeccionDB();
        }
        
        return instancia;
    }    
    
    private void cargarDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConeccionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Connection getConeccion(){
        cargarDriver();
        
        String url = "jdbc:mysql://localhost:3306/tallerjavadb";
        String usuario = "root";
        String clave = "rootweb";
        
         Connection connection = null;
        
        try {
             connection = DriverManager.getConnection(url,usuario, clave);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
}
