/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class ProbarConeccion {

    public static void main(String[] args) {
        ManejadorConeccion mConeccion = new ManejadorConeccion();

        //Asegurando que la coneccion se cierre luego de ser usada
        try (Connection con = mConeccion.getConeccion()) {

            if (con == null) {
                System.out.println("No hubo connecion !");
            } else {
                System.out.println("Coneccion exitosa");
            }

            //Asegurando que el recurso utilizado por Statement sea liberado luego de ser usado
            try (Statement stmt = con.createStatement()) {

                 //Asegurando que el recurso utilizado por ResultSet sea liberado luego de ser usado
                try (ResultSet rs = stmt.executeQuery("select * from PRODUCT")) {

                    while (rs.next()) {
                        
                        //Obteniendo datos de la coleccion de datos
                        System.out.println("ID" + rs.getInt("PRODUCT_ID")
                                + " Nombre :" + rs.getString("DESCRIPTION"));
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProbarConeccion.class.getName()).log(Level.SEVERE, null, ex); //Clase Logger nos permite manejar los logs
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProbarConeccion.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
