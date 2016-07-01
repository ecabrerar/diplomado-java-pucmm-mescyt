/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ecabrerar
 */
public class ColorTableRenderer extends JLabel implements TableCellRenderer {

    Border unselectedBorder = null;
    Border selectedBorder = null;
    boolean isBordered = true;

    public ColorTableRenderer(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        
        org.diplomado.pucmm.mescyt.Color color = org.diplomado.pucmm.mescyt.Color.valueOf(value.toString());
                
        setToolTipText(color.name()); //Tooltip para la columna del color
        
        setBackground(getColorFromText(color));

        if (isBordered) {
            if (selectedBorder == null) {
                selectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, table.getSelectionBackground());
            }

            setBorder(selectedBorder);

        } else {
            if (unselectedBorder == null) {
                unselectedBorder = BorderFactory.createMatteBorder(2, 5, 2, 5, table.getBackground());
            }

            setBorder(unselectedBorder);
        }

        return this;

    }

    /**
     * Convertir el valor de la columna en texto a un objeto Color
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
