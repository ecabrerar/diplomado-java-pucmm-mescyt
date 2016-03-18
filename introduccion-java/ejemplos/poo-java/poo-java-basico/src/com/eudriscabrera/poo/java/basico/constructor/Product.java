package com.eudriscabrera.poo.java.basico.constructor;

/**
 * 
 * @author ecabrerar
 */
public class Product {
    
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {

        this.setCode(code);
        this.setDescription(description);
        this.setPrice(price);
    }

    public Product(){
        
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
