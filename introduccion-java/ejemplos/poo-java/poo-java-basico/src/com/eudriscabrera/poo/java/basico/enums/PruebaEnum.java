/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.poo.java.basico.enums;

/**
 *
 * @author ecabrerar
 */
public class PruebaEnum {
    public static void main(String[] args) {
        System.out.println(" "+Dias.DOMINGO.getDescripcion());          
         
         for (Dias arg : Dias.values()) {
            
         System.out.println(" "+arg.getCodigo()+" >"+arg.getDescripcion());
        }
         
    }
}
