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
public class Magazine extends Product{
    
    private Date dateRelease;

    public Magazine() {
    }
    

    public Magazine(Date dateRelease, String code, String description, double price) {
        super(code, description, price);
        this.dateRelease = dateRelease;
    }    

    public Magazine(String code, String description, double price) {
        super(code, description, price);
    }   
    

    @Override
    public String getDisplayText() {
        return super.toString()+" "+" Date Release:"+dateRelease;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }
    
}
