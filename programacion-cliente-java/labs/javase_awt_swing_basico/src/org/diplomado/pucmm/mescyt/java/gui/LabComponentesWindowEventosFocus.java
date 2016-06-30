/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 *
 * @author eudriscabrera
 */
public class LabComponentesWindowEventosFocus extends JFrame implements WindowFocusListener{

    public LabComponentesWindowEventosFocus() throws HeadlessException {
        addWindowFocusListener(this);
    }
    
    @Override
    public void windowGainedFocus(WindowEvent e) {
        System.out.println("WindowFocusListener : windowGainedFocus");
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        
          System.out.println("WindowFocusListener : windowLostFocus");
    }    
    
    public static void main(String[] args) {
        LabComponentesWindowEventosFocus frm = new LabComponentesWindowEventosFocus();
        frm.setVisible(true);
        frm.setSize(400, 300);
        
    }    
}
