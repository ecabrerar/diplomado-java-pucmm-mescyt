package com.eudriscabrera.poo.java.basico.abstracta;

/**
 * 
 * @author ecabrerar
 */
public abstract class Product {
    
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {
        super();
        this.code = code;
        this.description = description;
        this.price = price;
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
    
    @Override
    public String toString(){
        return "Code:         "+ code +" \n"+
                "Descripcion :"+ description +" \n"+
                "Price:       "+ price + "\n";
    }
    public abstract String getDisplayText();
}