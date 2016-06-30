/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author eudriscabrera
 */
public class LabComponentesWindowEventos extends JFrame implements WindowListener {

    public LabComponentesWindowEventos() throws HeadlessException {
        
        addWindowListener(this);
    }
    
    

    @Override
    public void windowOpened(WindowEvent e) {
        displayMessage("WindowListener: windowOpened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
       displayMessage("WindowListener: windowClosing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        displayMessage("WindowListener: windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
         displayMessage("WindowListener: windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
         displayMessage("WindowListener: windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
          displayMessage("WindowListener: windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
          displayMessage("WindowListener: windowDeactivated");
    }
    
    
    private void displayMessage(String msg) {       
        System.out.println(msg);
    }
    
    public static void main(String[] args) {
        LabComponentesWindowEventos frame = new LabComponentesWindowEventos();
        frame.setVisible(true);
        frame.setSize(new Dimension(400, 300));
    }

}
