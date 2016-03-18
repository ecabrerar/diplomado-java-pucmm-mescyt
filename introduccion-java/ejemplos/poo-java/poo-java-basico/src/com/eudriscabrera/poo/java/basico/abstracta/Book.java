package com.eudriscabrera.poo.java.basico.abstracta;

/**
 * 
 * @author ecabrerar
 */
public class Book extends Product {
    private String Author;
    public Book(String string, String string1, double d) {
        super(string, string1, d);
    }
    
    public Book(){
        
    }

    @Override
    public String getDisplayText() {
        return super.toString()+ " \n"+ Author+ " \n";
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
}
