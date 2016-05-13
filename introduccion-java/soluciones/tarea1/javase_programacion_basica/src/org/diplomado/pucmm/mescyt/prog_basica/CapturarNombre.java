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
public class CapturarNombre {
    
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        
        String opcion = "s";
        
        while(opcion.equalsIgnoreCase("s")){
        System.out.println(" Digite Nombre: ");
        
        String nombre  = sc.next();
        
        System.out.println(" Digite Edad: ");
        
        
         int edad =  Integer.parseInt(sc.next());
         
         if(edad < 40){
             System.out.println(String.format("Hola %s, todavia eres muy joven", nombre));
         } else if(edad > 60){
               System.out.println(String.format("Hola %s, eres de avanzada edad ", nombre));
         }
         
            System.out.println();
            System.out.println("Desea continuar (s/n) ?");
            
            opcion = sc.next();
       }
    }
    
}
