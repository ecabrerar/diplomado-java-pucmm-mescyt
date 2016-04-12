/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.poo.herencia;

/**
 *
 * @author ecabrerar
 */
public class AutoShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sedan sdn = new Sedan(15, 5, 20000, "Silver");
        
        Ford ford1 = new Ford(2010, 3000, 5, 25000, "Black");
        Ford ford2 = new Ford(2011, 5000, 5, 35000, "White");
        
        Carro car = new Carro(5, 18000, "Red");
        
        System.out.println("Sedan Precio Venta :"+sdn.getPrecioVenta());
        System.out.println("Ford Precio Venta : "+ford1.getPrecioVenta());
        System.out.println("Ford II Precio Venta : "+ford2.getPrecioVenta());
        System.out.println("Carro Precio Venta :"+car.getPrecioVenta());
        
    }
}
