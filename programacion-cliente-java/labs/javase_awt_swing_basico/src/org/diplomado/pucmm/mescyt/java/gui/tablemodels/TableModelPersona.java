/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.gui.tablemodels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.diplomado.pucmm.mescyt.java.encapsulados.Genero;
import org.diplomado.pucmm.mescyt.java.encapsulados.Persona;

/**
 *
 * @author ecabrerar
 */
public class TableModelPersona extends AbstractTableModel{

    private List<Persona> dataArray;
    private List<String> columnas;

    
    public TableModelPersona() {
        columnas = new ArrayList<>();
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("Edad");
        
       dataArray = new ArrayList<>();
       dataArray.add(new Persona("Juana", "Perez", Genero.FEMENINO, 37));
       dataArray.add(new Persona("Rita", "Perez", Genero.FEMENINO, 15));
       dataArray.add(new Persona("Maria", "Rosa", Genero.FEMENINO, 25));
       dataArray.add(new Persona("Luz", "Santos", Genero.FEMENINO, 30));
       dataArray.add(new Persona("Juan", "Perez", Genero.MASCULINO, 55));
       dataArray.add(new Persona("Victor", "Martinez", Genero.MASCULINO, 32));

    }    
    
    @Override
    public int getRowCount() {
       return dataArray.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnas.get(column);
    }
    
    public Object getRow(int row ){
        return dataArray.get(row);
    }

    @Override
    public int getColumnCount() {
        return columnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     
     Persona p =   dataArray.get(rowIndex);
     
     switch(columnIndex){
         case 0:
           return  p.getNombre();
            
         case 1:
             return p.getApellido();
         case 2:
             return p.getEdad();
     }
        return null;
    }
    
}
