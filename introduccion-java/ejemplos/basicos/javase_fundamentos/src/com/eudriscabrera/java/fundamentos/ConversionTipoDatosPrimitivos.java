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
public class ConversionTipoDatosPrimitivos {
    
    public static void main(String[] args) {
        // Ejemplo conversión implícita 1
        int     numInt = 10;
        double  numDouble = numInt;
        System.out.println("int " + numInt + " fue convertido de forma implícita a double " + numDouble);
       
        // Ejemplo conversión implícita  2
        int    numInt1 = 1;
        int    numInt2 = 2;
        double  numDouble2 = numInt1/numInt2;
        System.out.println("numInt1/numInt2 " + numInt1/numInt2 + " fue convertido de forma implícita a double " + numDouble2);
       
        // Ejemplo conversión explícita 1
        double  valDouble = 10.12;
        int     valInt = Double.valueOf(valDouble).intValue();
                
        System.out.println("double " + valDouble + " fue convertido de forma explícita a  int " + valInt);
       
        // Ejemplo conversión explícita 2
        double x = 10.2;
        int y = 2;
        int resultado = (int)(x/y);
        System.out.println("x/y " + x/y + " fue convertido de forma explícita a int " + resultado);

    }
}
