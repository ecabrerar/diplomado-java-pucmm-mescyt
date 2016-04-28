/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.prog_basica;

import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class TestInput {
    public static void main(String[] args){
 
    // crear un objeto de la clase Scanner
   Scanner sc = new Scanner(System.in);

   // Leer 3 valores enteros
   System.out.print("Digite 3 enteros: ");
   
   int contador = 0;
   
    Double valor1 = sc.nextDouble();
    
    Double valor2 = sc.nextDouble();
    
    Double valor3 = sc.nextDouble();
    
   
    double sumatoria = valor1+valor2+valor3;
    
        System.out.println("promedio : "+ sumatoria / 3);
    
 }
}
