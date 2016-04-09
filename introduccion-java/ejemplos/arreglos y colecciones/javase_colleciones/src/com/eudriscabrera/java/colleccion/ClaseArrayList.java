package com.eudriscabrera.java.colleccion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author ecabrerar
 * @date Sat Sep 27 17:29:38 AST 2014
 * @since 1.0
 * @see ArrayList
 */
public class ClaseArrayList {

    public static void main(String[] args) {

        List<String> libros = new ArrayList<>();
        libros.add("El Principito");
        libros.add("El coronel no tiene quien le escriba");
       
       
        System.out.println("lo contiene :"+libros.indexOf("El Principito"));
        
        System.out.println("lo contiene :"+libros.contains("El Principito"));
        
        List<String> libros2 = Arrays.asList("Effective Java"," Java Head Firt");

        for (int i = 0; i < libros.size(); i++) {
            System.out.println(" Bucle For Tradicional " + libros.get(i));

        }

        for (String string : libros) {
            System.out.println("Bucle For Mejorado " + string);

        }

        ArrayList<Integer> enteros = new ArrayList<>();
        enteros.add(1);
        enteros.add(15);
        enteros.add(32);

        for (Iterator<Integer> it = enteros.iterator(); it.hasNext();) {
            Integer integer = it.next();

            System.out.println(" Iterator: " + integer);

        }

        ArrayList<Product> productos = new ArrayList<>();

        Product p = new Product();
        p.setCode("LB15");
        p.setDescripcion("Set Herramienta");
        p.setPrecio(70.98);

        Product p1 = new Product();
        p1.setCode("TI10");
        p1.setDescripcion("Taladro");
        p1.setPrecio(1070.96);

        productos.add(p);
        productos.add(p1);

        for (Product product : productos) {
            System.out.println(product.getCode());
        }

        List list1 = new ArrayList();
        
        List<Integer> numeros = Arrays.asList(50,30,55,60);
        
        
        Collections.sort(numeros);   
         Collections.reverse(numeros);   
         Collections.shuffle(numeros);
        
   
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
      

    }
}
