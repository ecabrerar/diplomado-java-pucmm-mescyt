package com.eudriscabrera.poo.java.basico.estatico;

/**
 * 
 * @author ecabrerar
 */
public class MetodoEstatico {
    
    public static double realizarDescuento(double precio){
        return precio - (precio * 0.1); 
    }
    
    public static void main(String[] args){
      double precio = 120.98;
      double precioFinal = realizarDescuento(precio);
      
      System.out.println(" Precio Final: "+precioFinal);
    }    
    
}
