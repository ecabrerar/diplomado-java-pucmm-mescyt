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
        if(Fruta.MANGO.equals(fruta)){
            System.out.println("Mango es muy bueno.");
        }else if(Fruta.SANDIA.equals(fruta)){
            System.out.println("No me gusta la sandía. ");
        }else if(Fruta.NARANJA.equals(fruta)){
            System.out.println("La naranja es muy buena pero prefiero el zapote. ");
        }else if(Fruta.MELON.equals(fruta)){
            System.out.println("El melón es mi favorito. ");
        }
    }
    
    public static void main(String[] args) {
        
        PruebaEnum frutaMango = new PruebaEnum(Fruta.MANGO);
        frutaMango.decirSiTeGusta();
        
         PruebaEnum frutaSandia = new PruebaEnum(Fruta.SANDIA);
         frutaSandia.decirSiTeGusta();
         
        PruebaEnum frutaNaranja = new PruebaEnum(Fruta.NARANJA);
        frutaNaranja.decirSiTeGusta();
        
         PruebaEnum frutaMelon = new PruebaEnum(Fruta.MELON);
         frutaMelon.decirSiTeGusta();
        
        
    }
}
