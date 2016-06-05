/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui.utilidades;

import javax.swing.JFrame;

/**
 *
 * @author ecabrerar
 */
public class CentrarJFrame {
    public static void main(String[] args) {
       JFrame frame = new JFrame();
       frame.setTitle("Frame Centralizado");
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

       frame.setVisible(true);
       
    }
}
