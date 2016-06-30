/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ecabrerar
 */
public class ComboBoxColoresRenderer extends JLabel implements ListCellRenderer{

    public ComboBoxColoresRenderer() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    
    
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
   
        if(isSelected){
        
          setBackground(getColorFromText(org.diplomado.pucmm.mescyt.Color.valueOf(value.toString())));
        }
        
        return this;
    }
    
    
    /**
     * Convertir el valor de la columna en texto a un Objeto Color
     * @param color
     * @return 
     */
    private Color getColorFromText(org.diplomado.pucmm.mescyt.Color color) {

        switch (color) {
            case BLANCO:
                return Color.WHITE;
            case NEGRO:
                return Color.BLACK;
            case GRIS:
                return Color.GRAY;
            case ROJO:
                return Color.RED;
            default:
                return null;
        }
    }
    
}
