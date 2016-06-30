/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eudriscabrera
 */
public class LabComponentesKeyEventos extends JDialog implements KeyListener{

    private JFormattedTextField txtVlrNumero;
    private final double vlrNumero = 0.00;
    private NumberFormat formatoNumero;

    public LabComponentesKeyEventos(Frame owner) {
        super(owner);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        formatoNumero = NumberFormat.getNumberInstance();
        formatoNumero.setMinimumFractionDigits(3);

        txtVlrNumero = new JFormattedTextField(formatoNumero);
        txtVlrNumero.setColumns(10);
        txtVlrNumero.setValue(vlrNumero);
        txtVlrNumero.setSize(new Dimension(30,5));
        
        txtVlrNumero.addKeyListener(this);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));

        panelPrincipal.add(txtVlrNumero);

        JPanel panelGrande = new JPanel(new GridLayout(0, 1));
        panelGrande.add(panelPrincipal);

        this.add(panelGrande);
        pack();
    }
    
    public static void main(String[] args) {
        LabComponentesKeyEventos frmKeyEventos = new LabComponentesKeyEventos(new JFrame());
        frmKeyEventos.setVisible(true);
        frmKeyEventos.setSize(400, 300);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        System.out.println(" KeyListener : keyTyped");
        System.out.println(" "+e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
          System.out.println(" KeyListener : keyPressed");
        System.out.println(" "+e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
          System.out.println(" KeyListener : keyReleased");
        System.out.println(" "+e.getKeyChar());
    }

}
