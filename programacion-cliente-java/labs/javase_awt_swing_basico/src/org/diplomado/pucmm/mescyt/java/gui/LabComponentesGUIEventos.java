/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author ecabrerar
 */
public class LabComponentesGUIEventos extends JDialog {

    private JLabel lblNumero;
    private JFormattedTextField txtVlrNumero;
    private JButton btnPulsar;
    private JComboBox comboBox;
    

    private double vlrNumero = 0.00;
    private NumberFormat formatoNumero;

    private NumberFormat formatoMoneda;

    public LabComponentesGUIEventos(Frame owner) {
        super(owner);

        inicializarComponentes();
        this.setTitle("Laboratorio Componentes ");
        this.setSize(300, 250);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void inicializarComponentes() {

        inicializarFormatos();

        lblNumero = new JLabel("Numero");

        txtVlrNumero = new JFormattedTextField(formatoNumero);
        txtVlrNumero.setColumns(10);
        txtVlrNumero.setValue(vlrNumero);
        txtVlrNumero.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                txtVlrNumero.setValue(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        
        txtVlrNumero.addPropertyChangeListener("value",new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                  Double numero = ((Long) txtVlrNumero.getValue()).doubleValue();
                  
                  JOptionPane.showMessageDialog(null, "Valor del campo "+numero);
            }
        });
        
        comboBox = new JComboBox();
        inicializarCombo();
        comboBox.setSelectedIndex(-1);
        
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
            }
        });

        comboBox.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                  System.out.println(" MouseInputListener : mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
                 System.out.println(" MouseInputListener : mousePressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
                  System.out.println(" MouseInputListener : mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 System.out.println(" MouseInputListener : mouseEntered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                System.out.println(" MouseInputListener : mouseExited");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(" MouseInputListener : mouseDragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                  System.out.println(" MouseInputListener : mouseMoved");
            }
        });
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));

        panelPrincipal.add(lblNumero);
        panelPrincipal.add(txtVlrNumero);
        panelPrincipal.add(comboBox);

        btnPulsar = new JButton("Pulsar");
        btnPulsar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Double numero = ((Long) txtVlrNumero.getValue()).doubleValue();

                JOptionPane.showMessageDialog(null, formatoMoneda.format(numero));
            }
        });
        btnPulsar.setSize(30, 1);

        JPanel panelBotones = new JPanel(new GridLayout(0, 1));
        panelBotones.add(btnPulsar);

        JPanel panelGrande = new JPanel(new GridLayout(3, 1));
        panelGrande.add(panelPrincipal);
        panelGrande.add(panelBotones);

        this.add(panelGrande);
        pack();
    }

    private void inicializarFormatos() {
        formatoNumero = NumberFormat.getNumberInstance();
        formatoNumero.setMinimumFractionDigits(3);

        formatoMoneda = NumberFormat.getCurrencyInstance();
    }
    
    private void inicializarCombo(){
        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>(new String[]{"JTable","JRadioButton","GroupButton"});
        comboBox.setModel(comboModel);
    }

    public static void main(String[] args) {
        LabComponentesGUIEventos labgui = new LabComponentesGUIEventos(new JFrame());
        labgui.setVisible(true);
    }

}
