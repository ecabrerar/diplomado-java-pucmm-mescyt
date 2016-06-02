/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ecabrerar
 */
public class CalculadoraPresupuesto {

    public static void main(String[] args) {

        double montoPresupuestado;
        
         List<Double> gastosFijos = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
           
            System.out.println("Digite el monto presupuestado:");
            
            montoPresupuestado = sc.nextDouble();
            
            while (true) {
                
                System.out.println("Digite gastos fijos:");
                
                double gasto = sc.nextDouble();

                if(gasto > 0){
                   gastosFijos.add(gasto);
                }else {
                    break;
                }               

            }
        }
        
        aplicarSumatoria(montoPresupuestado, gastosFijos);
    }
    
    public static void aplicarSumatoria(double montoPresupuestado, List<Double> gastosFijos){
        
        double sumatoriaGastosFijos = 0;
        
        for (Double gastoFijo : gastosFijos) {
            sumatoriaGastosFijos += gastoFijo;
        }
        
        double balance = montoPresupuestado - sumatoriaGastosFijos;
        
        if(balance < 0){
            System.out.println(String.format("Ha excedido lo presupuestado por RD$%.2f pesos",balance));
        } else if(balance > 0){
            System.out.println(String.format("Todavía está dentro de lo presupuestado, puedes gastar RD$%.2f pesos",balance));
        }else if(balance == 0){
            System.out.println("Gastaste exactamente lo presupuestado");
        }
        
    }
}
