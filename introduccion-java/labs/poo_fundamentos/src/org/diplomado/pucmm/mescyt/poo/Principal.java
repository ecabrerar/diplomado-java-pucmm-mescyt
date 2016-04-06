/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.poo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ecabrerar
 */
public class Principal {
    public static void main(String[] args) {
        
        Telefono tel1= new Telefono("Piperito", Marca.ALCATEL, "Desconocido");
        Telefono tel2= new Telefono("V60i", Marca.MOTOROLA, "V60i");
        
        List<Telefono> telefonos = new ArrayList<Telefono>();
        telefonos.add(tel1);
        telefonos.add(tel2);
        
        for (int i = 0; i < telefonos.size(); i++) {            
           System.out.println(telefonos.get(i).toString());
        }
        
        List<SmartPhone> smartphones = new ArrayList<SmartPhone>();
        smartphones.add(new SmartPhone("Nexus 4", Marca.LG, "E960"));
        smartphones.add(new SmartPhone("One Touch", Marca.ALCATEL, ""));
        
        for (SmartPhone smartphone : smartphones) {
            System.out.println(smartphone.toString());
        }
        
        List<Tablet> tabletas = new ArrayList<Tablet>();
        
        Tablet tablet1 = new Tablet("Galaxy TabPro", Marca.SAMSUNG, "S");
        tablet1.setSistemaOperativo(" Windows 10");
        tablet1.setMultiTactil(true);
        tablet1.setWifi(true);
        
        tabletas.add(tablet1);
        
        for (Tablet next : tabletas) {
            System.out.println(next.toString());
        }
        
    }
}
