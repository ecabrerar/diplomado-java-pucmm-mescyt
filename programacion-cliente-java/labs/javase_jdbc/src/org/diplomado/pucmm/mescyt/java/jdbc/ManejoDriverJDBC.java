/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.jdbc;

/**
 *
 * @author ecabrerar
 */
public class ManejoDriverJDBC {

    public static void main(String[] args) {
       
        try {
            //Cargando Driver para MySQL
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found " + e.getMessage());
        }
    }
}
