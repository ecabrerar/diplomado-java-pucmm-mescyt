package org.diplomado.pucmm.mescyt.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Ejemplo usando el motor de base de datos Java Derby DB y la base de datos sample que esta empostrada en netbeans
 * 
 * @author ecabrerar
 */
public class ManejoConeccion {

    private void cargarDriver() throws ClassNotFoundException {
        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    private void consultar() {

        try (Connection conn = miConeccion()) {

            try (Statement stmt = conn.createStatement()) {

                try (ResultSet rs = stmt.executeQuery("select * from CUSTOMER")) {

                    while (rs.next()) {
                        System.out.println(rs.getInt("CUSTOMER_ID") + " - " + rs.getString("NAME"));
                    }

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManejoConeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection miConeccion() throws SQLException {

        return DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app","app");       
    }
    
    public void ejectar (){
       
        try {
            cargarDriver();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManejoConeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        consultar();
    }

    public static void main(String[] args) {
        ManejoConeccion mConeccion = new ManejoConeccion();
        mConeccion.ejectar();
    }
}
