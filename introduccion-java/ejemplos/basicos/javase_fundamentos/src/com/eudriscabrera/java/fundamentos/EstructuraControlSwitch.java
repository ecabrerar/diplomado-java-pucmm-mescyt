/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.java.fundamentos;

import com.eudriscabrera.java.fundamentos.EstructuraControlSwitch.Marca;

/**
 *
 * @author ecabrerar
 */
public class EstructuraControlSwitch {

    enum Marca {

        DELL, TOSHIBA, SAMSUNG;
    }

    public void ejecutar(Marca m) {     

        switch (m) {
            case DELL:
                System.out.println("Es dell");
                break;
            case TOSHIBA:
                System.out.println("Es Toshiba");
                break;
            default:
                System.out.println("Ninguna");
              
        }
    }
    
    public static void main(String[] args) {
        EstructuraControlSwitch esw = new EstructuraControlSwitch();
        esw.ejecutar(Marca.SAMSUNG);
         esw.ejecutar(Marca.TOSHIBA);
    }

}
