/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eudriscabrera.java.colleccion;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ecabrerar
 */
public class TipoSet {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(4);
        set.add(5);
        
        set.remove(2);
        for (Integer set1 : set) {         
                        
            System.out.println(set1);
        }
        
        
    }
}
