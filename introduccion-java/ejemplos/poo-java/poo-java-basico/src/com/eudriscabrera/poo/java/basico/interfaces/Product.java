package com.eudriscabrera.poo.java.basico.interfaces;

/**
 * 
 * @author ecabrerar
 */
public class Product implements Printable {
    
    private String code;
    private String description;
    private double price;
    
    public Product() {
       
    }

    @Override
    public void print() { //implementar la interfaz Printable
        System.out.println(" Code :"+code);
        System.out.println(" Descripcion :"+description);
        System.out.println(" Price :"+price);
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
