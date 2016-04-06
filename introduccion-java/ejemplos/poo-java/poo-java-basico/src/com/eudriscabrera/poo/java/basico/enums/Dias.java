/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.poo.java.basico.enums;

/**
 *
 * @author ecabrerar
 */
public enum Dias {   
    
    
    DOMINGO(1,"Domingo"), LUNES(2,"Lunes"), MARTES(3,"Martes"), MIERCOLES(4,"Miercoles"),JUEVES(5,"Jueves"),
    VIERNES(6,"Viernes"), SABADO(7,"Sabado");
    
    int codigo;
    String descripcion;
    
    Dias(int codigo, String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    }  
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
}
