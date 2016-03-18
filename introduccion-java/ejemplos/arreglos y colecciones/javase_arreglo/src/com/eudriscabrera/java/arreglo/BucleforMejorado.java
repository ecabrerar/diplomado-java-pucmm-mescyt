package com.eudriscabrera.java.arreglo;

public class BucleforMejorado {
    public static void main(String[] args) {
        
        
        int[] notasAbr = {100, 80, 90, 75, 60, 50, 70, 80, 90,100};

        //obtener el promedio de la nota sacada en el grupo
        
        double total = 0;
        
        for(double nota : notasAbr){
            total += nota;
        }
        
        
        
        double promedio = total / notasAbr.length;
        
        System.out.println("For Mejorado(enhanced): El promedio del grupo es de: "+promedio);

        
    }
}
