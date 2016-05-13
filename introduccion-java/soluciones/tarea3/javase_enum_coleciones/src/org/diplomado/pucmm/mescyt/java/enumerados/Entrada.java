/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.enumerados;

/**
 *
 * @author eudriscabrera
 */
public enum Entrada {
    
  BALCON(1000), PLATEA(1500),VIP(2500),FRONT_STAGE_PLATINUM(3000);
  
  private final double precio;

   private Entrada(double precio) {
        this.precio = precio;
   }  
   
   public double getPrecio(){
       return this.precio;
   }
  
}
