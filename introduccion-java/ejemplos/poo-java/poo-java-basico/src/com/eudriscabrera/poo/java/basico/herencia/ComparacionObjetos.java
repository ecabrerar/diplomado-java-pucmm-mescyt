package com.eudriscabrera.poo.java.basico.herencia;
import com.eudriscabrera.poo.java.basico.abstracta.Book;
/**
 * 
 * @author ecabrerar
 */
public class ComparacionObjetos {
    public static void main(String[] args) {
        Book b = null;
        
        //validar si un objeto fue creado
        
        if(b instanceof Book){
            //Entra a este segmento de codigo si la variable b fue inicializada
            System.out.println("Inicializado");
        }else {
            System.out.println(" No Inicializado");
        }
        
        
        //inicializar objeto
        b = new Book();


        if(b instanceof Book){
            //Entra a este segmento de codigo si la variable b fue inicializada
            System.out.println("Inicializado");
        }else {
            System.out.println(" No Inicializado");
        }
        
    }
}
