/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author ecabrerar
 */
public class LabComponentesGUI extends JDialog
implements ActionListener, FocusListener{
    
    private JLabel lblNumero;
    private JFormattedTextField txtVlrNumero;
    private JButton btnPulsar;
    
    private double vlrNumero = 0.00;
    private NumberFormat formatoNumero;

    private NumberFormat formatoMoneda;
    
    public LabComponentesGUI(Frame owner) {
        super(owner);
        
        inicializarComponentes();
        this.setTitle("Laboratorio Componentes ");
        this.setSize(300, 250);
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    } 
    
    private void inicializarComponentes(){
        
        inicializarFormatos();
        
        lblNumero = new JLabel("Numero");
        
        txtVlrNumero = new JFormattedTextField(formatoNumero);
        txtVlrNumero.setColumns(10);
        txtVlrNumero.setValue(vlrNumero);
        txtVlrNumero.addFocusListener(this);
        txtVlrNumero.setPreferredSize(new Dimension(50, 5));
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 1));
        
        panelPrincipal.add(lblNumero);
        panelPrincipal.add(txtVlrNumero);       
              
        
        btnPulsar = new JButton("Pulsar");
        btnPulsar.addActionListener(this);
        btnPulsar.setSize(30, 1);
        
        JPanel panelBotones = new JPanel(new GridLayout(0, 1));
        panelBotones.add(btnPulsar);
        
                
        JPanel panelGrande = new JPanel(new GridLayout(3, 1));
        panelGrande.add(panelPrincipal); 
        panelGrande.add(panelBotones);  
        
        pack();
    }
    
    private void inicializarComponentesBorderLayout(){
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        
        panelPrincipal.add(lblNumero,BorderLayout.LINE_START);
        panelPrincipal.add(txtVlrNumero,BorderLayout.CENTER);       
              
        
        btnPulsar = new JButton("Pulsar");
        btnPulsar.addActionListener(this);
        btnPulsar.setPreferredSize(new Dimension(100,5));
        
         panelPrincipal.add(btnPulsar,BorderLayout.LINE_END);
        
                
        JPanel panelGrande = new JPanel(new BorderLayout());
        panelGrande.add(panelPrincipal,BorderLayout.LINE_START); 
        
        this.add(panelGrande);
        this.setPreferredSize(new Dimension(300, 200));
        setResizable(false);      
        
        pack();
        
    }
    
    private void inicializarFormatos(){
        formatoNumero = NumberFormat.getNumberInstance();
        formatoNumero.setMinimumFractionDigits(3);
        
        formatoMoneda = NumberFormat.getCurrencyInstance();
    }
    
    public static void main(String[] args) {
        LabComponentesGUI labgui = new LabComponentesGUI(new JFrame());
        labgui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       Double numero =  ((Long) txtVlrNumero.getValue()).doubleValue();
        
        JOptionPane.showMessageDialog(this, formatoMoneda.format(numero));
    }

    @Override
    public void focusGained(FocusEvent e) {
      txtVlrNumero.setValue(null);
    }

    @Override
    public void focusLost(FocusEvent e) {
      
    }
}
