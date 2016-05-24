/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author ecabrerar
 */
public class MiPrimerGUI extends JFrame{

    public MiPrimerGUI() {
       this.setSize(new Dimension(400, 700));
        agregaComponentes();
       
     }

    public MiPrimerGUI(String title){
        super(title);
        this.setSize(new Dimension(400, 400)); 
        this.setResizable(true);
        agregaComponentes();
        
         this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void agregaComponentes(){
        JPanel panel = new JPanel();
        
        JLabel label1 = new JLabel();
        label1.setText("Digite su nombre:");
        
        panel.add(label1);
        panel.setEnabled(true);
       
        JTextField texto = new JTextField(10);
       
        JButton boton = new JButton();
        boton.setText("Pulsar Aqui");
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, texto.getText());
            }
        });
        
        
        panel.add(texto);
        panel.add(boton);
        
        this.add(panel);     
        
    }
    
    public static void main(String[] args) {
        MiPrimerGUI gui = new MiPrimerGUI("Mi Primer GUI Java");
        gui.setLocation(300, 200);
        gui.setEnabled(true);        
        gui.setVisible(true);
        
    }
}
