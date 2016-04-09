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
public class PruebaEnum {
    Fruta fruta;

    public PruebaEnum(Fruta fruta) {
        this.fruta = fruta;
    }
    
    public void decirSiTeGusta(){
        
    }
    
    public static void main(String[] args) {
        
        PruebaEnum frutaMango = new PruebaEnum(Fruta.MANGO);
        frutaMango.decirSiTeGusta();
        
        PruebaEnum frutaNaranja = new PruebaEnum(Fruta.NARANJA);
        frutaNaranja.decirSiTeGusta();
        
    }
}
