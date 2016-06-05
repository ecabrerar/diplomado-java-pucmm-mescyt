/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui.utilidades;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author ecabrerar
 */
public class CentrarJDialog {
    
    public static void main(String[] args) {
        JDialog dialog  = new JDialog(new JFrame(), true); 
        dialog.setSize(300, 200); //Tamaño del Dialog
        
         Dimension d = dialog.getSize();
         Dimension d1 = dialog.getToolkit().getScreenSize();

        dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);

        dialog.setVisible(true);

    }
}
