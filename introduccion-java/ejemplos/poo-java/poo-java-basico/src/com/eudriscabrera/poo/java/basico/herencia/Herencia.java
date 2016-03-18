package com.eudriscabrera.poo.java.basico.herencia;

/**
 * 
 * @author ecabrerar
 */
public class Herencia {
    public static void main(String[] args) {
        Book book = new Book();
        book.setCode("IBN- 8970");
        book.setDescription("Murach's Java SE 6");
        book.setPrice(7.90);
        book.setAuthor("Joel Murach");
        
        
        Software softw = new Software();
        softw.setCode("INS 6400");
        softw.setDescription("Microsoft Office");
        softw.setPrice(495.70);
        softw.setVersion("Office 2010");
        
        //Todo: Imprimir valores
        
        
    }
}
