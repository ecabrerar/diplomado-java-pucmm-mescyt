package com.eudriscabrera.poo.java.basico.herencia;

import com.eudriscabrera.poo.java.basico.encapsulacion.Product;

/**
 * 
 * @author ecabrerar
 */

public final class Tipofinal extends Product {
    private final String version="V1";
    
    //cuando una clase es final, todos los metodos deben ser final
    
    public Tipofinal() {
        super();
    }


    public final String getVersion() {
        return version;
    }
}
