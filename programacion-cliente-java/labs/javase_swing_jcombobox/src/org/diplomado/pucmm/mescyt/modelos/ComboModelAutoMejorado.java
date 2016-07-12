/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.modelos;

import java.util.ArrayList;
import java.util.List;
import org.diplomado.pucmm.mescyt.Auto;
import org.diplomado.pucmm.mescyt.Color;
import org.diplomado.pucmm.mescyt.Marca;

/**
 *
 * @author ecabrerar
 */
public class ComboModelAutoMejorado extends ComboBoxModelStandard<Auto>{

    public ComboModelAutoMejorado() {
        
        List<Auto> objects = new ArrayList<>();

        objects.add(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO));
        objects.add(new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO));
        
        setData(objects);
    }    
    
}
