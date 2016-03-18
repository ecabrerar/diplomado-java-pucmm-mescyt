package com.eudriscabrera.poo.java.basico.encapsulacion;

/**
 * 
 * @author ecabrerar
 */
public class Product {
       
    private String code;
    private String description;
    private double price;
    private String version;



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
