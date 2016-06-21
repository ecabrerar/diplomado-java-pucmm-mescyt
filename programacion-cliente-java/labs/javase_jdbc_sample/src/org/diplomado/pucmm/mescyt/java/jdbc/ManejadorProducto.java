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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.diplomado.pucmm.mescyt.java.jdbc.encapsulados.Producto;

/**
 *
 * @author ecabrerar
 */
public class ManejadorProducto {

    /**
     * Devuelve un List del tipo producto
     * @return 
     */
    public List<Producto> getListadoProducto() {
        List<Producto> productos = new ArrayList<>();

        try {

            ManejadorConeccion con = new ManejadorConeccion();

            Connection coneccion = con.getConeccion();

            try (Statement stmt = coneccion.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("select * from Product")) {

                    while (rs.next()) {
                        Producto p = new Producto(rs.getInt("PRODUCT_ID"),
                                rs.getString("DESCRIPTION"),
                                rs.getInt("QUANTITY_ON_HAND"));

                        productos.add(p);
                    }
                }

            } finally {
                coneccion.close(); //Cerrar coneccion manualmente
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productos;
    }
}
