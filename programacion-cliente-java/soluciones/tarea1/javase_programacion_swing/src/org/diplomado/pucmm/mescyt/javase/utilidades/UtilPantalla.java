/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.javase.utilidades;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author ecabrerar
 */
public class UtilPantalla {
    private JDialog dialog;
    private JFrame frame;

    public UtilPantalla(JDialog dialog) {
        this.dialog = dialog;
    }

    public UtilPantalla(JFrame frame) {
        this.frame = frame;
    }
    
    public void centrar(){
        //Obtener la dimension del JDialog
        Dimension d = dialog.getSize(); 
        //Obtener la dimension de la pantalla
        Dimension d1 = dialog.getToolkit().getScreenSize();
        
        dialog.setLocation((d1.width-d.width)/2, (d1.height-d.height)/2);
    }
    
    public void maximizar(){
        //En el caso de los JFrame se recomienda usar la siguiente sintaxis.
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}