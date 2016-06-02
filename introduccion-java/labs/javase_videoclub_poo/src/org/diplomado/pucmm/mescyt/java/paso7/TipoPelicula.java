/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso7;

/**
 *
 * @author ecabrerar
 */
public enum TipoPelicula {
   NORMAL(1),INFANTIL(2),NOVEDAD(3);
   
   private final int tipo;
   
  private TipoPelicula(int tipo){
       this.tipo = tipo;
   }
  
  public int getTipo(){
      return tipo;
  }
}
