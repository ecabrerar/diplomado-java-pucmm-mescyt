/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import org.diplomado.pucmm.mescyt.Auto;
import org.diplomado.pucmm.mescyt.Color;
import org.diplomado.pucmm.mescyt.Marca;

/**
 *
 * @author ecabrerar
 */
public class ComboModelAuto extends AbstractListModel implements ComboBoxModel{
    
   private final List<Auto> objects;
   protected Object selectedObject = null; 

    public ComboModelAuto() {
        
        objects =  new ArrayList<>();

        objects.add(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO));
        objects.add(new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO));
    }

    
    @Override
    public int getSize() {
        return objects.size();
    }

    @Override
    public Object getElementAt(int index) {
        return ((Auto)objects.get(index)).getModelo();
    }
    
    public Auto getData(int index){
        return objects.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        
        if((selectedObject !=null && !selectedObject.equals(anItem)) ||
            selectedObject == null && anItem !=null){
            
            selectedObject = anItem; 
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedObject;
    }
    
}
