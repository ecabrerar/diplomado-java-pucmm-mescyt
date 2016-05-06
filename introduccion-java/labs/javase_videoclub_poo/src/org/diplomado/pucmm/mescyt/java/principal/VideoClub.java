/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.principal;

import org.diplomado.pucmm.mescyt.java.paso3.Alquiler;
import org.diplomado.pucmm.mescyt.java.paso3.Cliente;
import org.diplomado.pucmm.mescyt.java.paso3.DVD;
import org.diplomado.pucmm.mescyt.java.paso3.TipoPelicula;

/**
 *
 * @author ecabrerar
 */
public class VideoClub {
    
    public void ejecutar(){
       
        DVD dvd = new DVD("La Mascara", TipoPelicula.NORMAL);
        DVD dvd1 = new DVD("Kunfu Panda 3", TipoPelicula.NOVEDAD);        
        
        Alquiler alq1 = new Alquiler();
        alq1.setDvd(dvd);
        alq1.setTiempo(5);
        
        Alquiler alq2 = new Alquiler();
        alq2.setDvd(dvd1);
        alq2.setTiempo(2);        
                
        Cliente c = new Cliente();
        c.setNombre(" Juan Perez");
        c.setTelefono("809-555-5555");
        
        c.addAquiler(alq1);
        c.addAquiler(alq2);
        
        System.out.println(c.getFactura());
        
    } 
    
    
     public static void main(String[] args) {
        VideoClub vc = new VideoClub();
        vc.ejecutar();       
    }
}
