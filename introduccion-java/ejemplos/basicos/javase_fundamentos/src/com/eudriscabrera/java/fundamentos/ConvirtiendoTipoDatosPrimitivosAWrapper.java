/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eudriscabrera.java.fundamentos;

/**
 *
 * @author ecabrerar
 */
public class ConvirtiendoTipoDatosPrimitivosAWrapper {
    public static void main(String[] args) {
        // Crear instancia de objeto Integer
        Integer contador = new Integer(7801);
       
        // Convertir tipo Integer a tipo primitivo int usando el método intValue()
        int newCount = contador.intValue();
        System.out.println("int nuevoContador = " + newCount);
       
        //Usando método estático de la clase wrapper Integer
        //para convertir un tipo de dato String String a un tipo de dato
        //entero primitivo int
        String pennsylvania = "65000";
        int penn = Integer.parseInt(pennsylvania);
        System.out.println("int penn = " + penn);
       
        // Converyir tipo de dato entero primitivo int a tipo Integer
        Integer miInteger = new Integer(penn);
        System.out.println("Integer miInteger = " + miInteger);
    }
}
