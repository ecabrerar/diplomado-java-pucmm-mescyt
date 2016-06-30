/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 *
 * @author eudriscabrera
 */
public class LabComponentesWindowEventosEstados extends JFrame implements WindowStateListener{

    public LabComponentesWindowEventosEstados() {
        addWindowStateListener(this);
    }   
    

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("WindowStateListener : windowStateChanged");
    }
    
    public static void main(String[] args) {
        LabComponentesWindowEventosEstados frmEstado = new LabComponentesWindowEventosEstados();
        frmEstado.setVisible(true);
        frmEstado.setSize(400, 300);
    }
    
}
