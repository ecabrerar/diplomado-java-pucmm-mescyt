/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.paso4;

/**
 *
 * @author ecabrerar
 */
public class Alquiler {
    private DVD dvd;
    private int tiempo;
    private int puntos;

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public int getPuntos(){
        
         if(TipoPelicula.NOVEDAD.equals(getDvd().getTipo().NOVEDAD)
                    && getTiempo()>1){
                puntos ++;
            } 
         return puntos;
    }
    
    public double getImporte(){
        
        double importe=0;
         switch(getDvd().getTipo()){
                case NORMAL:                    
                    importe +=  70;
                    
                    if(getTiempo() > 2){
                        importe += (getTiempo()-2) * 5;
                    }                    
                   
                    break;
                case INFANTIL:
                    
                    importe += 60;
                    
                     if(getTiempo() > 3){
                        importe += (getTiempo()-3) * 5;
                    }                     
                    
                    break;
                case NOVEDAD:                    
                      importe += getTiempo() * 80;                      
                    break;
                    
                default:
                        break;
            }
            return importe;
    }
    
    
}
