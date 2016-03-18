package com.eudriscabrera.poo.java.basico.herencia;

import com.eudriscabrera.poo.java.basico.sobreescritura.Product;


/**
 * 
 * @author ecabrerar
 */
public class Software extends Product {
    private String version;
    
    public Software(String string, String string1, double d) {
        super(string, string1, d);
    }
    

    public Software(){
        
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
