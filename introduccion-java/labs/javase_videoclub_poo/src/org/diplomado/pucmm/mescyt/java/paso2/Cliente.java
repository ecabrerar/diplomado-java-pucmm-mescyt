/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Cliente {
    private String nombre;
    private String telefono;
    private List<Alquiler> alquileres;
    
    public Cliente(){
        alquileres= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void addAquiler(Alquiler alquiler){
        this.alquileres.add(alquiler);
    }
    
    public List<Alquiler> getAlquileres(){
        return alquileres;
    }
    
    public String getFactura(){
        StringBuilder sb = new StringBuilder(100);
        
        double importe = 0;
        double total = 0;
        int puntos = 0;
        
        for(Alquiler alq: alquileres){
            
            importe = alq.getImporte();
           
             sb.append("Titulo pelicula :").append(alq.getDvd().getTitulo());
             sb.append("Importe :").append(importe);
             sb.append("\n");
             
             
                        
            total +=importe;
            
        }
        
        sb.append(" Total:").append(total); 
        sb.append("Puntos :").append(puntos);
        
        return sb.toString();
    }
    
    
    
}
