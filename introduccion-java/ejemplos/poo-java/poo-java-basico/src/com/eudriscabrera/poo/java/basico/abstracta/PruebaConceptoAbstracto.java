/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.poo.java.basico.abstracta;

import java.util.Date;

/**
 *
 * @author ecabrerar
 */
public class PruebaConceptoAbstracto {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setDescription("Effective Java");
        book1.setAuthor("Josh Bloch");
        book1.setCode("ISBN-3675");
        book1.setPrice(25.90);
        System.out.println(" book1" +book1.getDisplayText());
        
        Book book2 = new Book("Java Head First","ISBN-3676",45.0);        
        book2.setPrice(25.90);
         book2.setAuthor("Katty Sierra");
        
        System.out.println(" book1" +book2.getDisplayText());
        
        Magazine mag = new Magazine();
        mag.setCode("ITC215");
        mag.setDescription("Java Magazine");
        mag.setPrice(0.0);
        mag.setDateRelease(new Date());
        
        System.out.println(" Magazine :"+mag.getDisplayText());
        
        Magazine mag1 = new Magazine(new Date(),"Oracle Press","ITC210",0.0);
        
 
        
        System.out.println(" Magazine :"+mag1.getDisplayText());
        
    }
}
