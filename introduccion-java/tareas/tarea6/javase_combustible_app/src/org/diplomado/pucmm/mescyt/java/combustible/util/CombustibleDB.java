/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.combustible.util;

import org.diplomado.pucmm.mescyt.java.combustible.Combustible;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class CombustibleDB {
    
    public static List<Combustible> getPrecio(){
        
        List<Combustible> listadoPrecios = new ArrayList<>();
        
        Combustible gasolinaRegular = new Combustible();
        gasolinaRegular.setDescripcion("Gasolina Regular");
        gasolinaRegular.setPrecio(167.10);
        gasolinaRegular.setTipo(Tipo.GASOLINA);
        
        Combustible gasolinaPremium = new Combustible();
        gasolinaPremium.setDescripcion("Gasolina Premium");
        gasolinaPremium.setPrecio(186.40);
        gasolinaPremium.setTipo(Tipo.GASOLINA);
         
        Combustible gasoilPremium = new Combustible();
        gasoilPremium.setDescripcion("Gasoil Premium");
        gasoilPremium.setPrecio(140.70);
        gasoilPremium.setTipo(Tipo.GASOIL);
        
        Combustible gasoilRegular = new Combustible();
        gasoilRegular.setDescripcion("Gasoil Regular");
        gasoilRegular.setPrecio(125.80);
        gasoilRegular.setTipo(Tipo.GASOIL);
        
        Combustible kerosene = new Combustible();
        kerosene.setDescripcion("Kerosene");
        kerosene.setPrecio(110.20);
        kerosene.setTipo(Tipo.KEROSENE);
        
        Combustible glp = new Combustible();
        glp.setDescripcion("Gas Licuado de Petróleo (GLP)");
        glp.setPrecio(86.60);
        glp.setTipo(Tipo.GLP);
        
        Combustible gnv = new Combustible();
        gnv.setDescripcion("Gas Natural Vehicular (GNV)");
        gnv.setPrecio(23.22);
        gnv.setTipo(Tipo.GNV);
        
        listadoPrecios.add(gnv);
        listadoPrecios.add(glp);
        listadoPrecios.add(gasoilPremium);
        listadoPrecios.add(gasoilRegular);
        listadoPrecios.add(gasolinaPremium);
        listadoPrecios.add(gasoilRegular);
                
       return listadoPrecios;
    } 
}
