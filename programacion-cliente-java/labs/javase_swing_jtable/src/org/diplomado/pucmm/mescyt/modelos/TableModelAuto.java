/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.diplomado.pucmm.mescyt.Auto;
import org.diplomado.pucmm.mescyt.Color;
import org.diplomado.pucmm.mescyt.Marca;

/**
 *
 * @author ecabrerar
 */
public class TableModelAuto extends AbstractTableModel {

    private final String[] columnas = {"Modelo", "Marca", "Año", "Color"};

    private final List<Auto> data;

    public TableModelAuto() {

        data = new ArrayList<>();

        data.add(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO));
        data.add(new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    
        Auto auto = (Auto) aValue;        
        data.add(auto);   
     
        /**
         * Si usamos el metodo fireTableCellUpdated(rowIndex, columnIndex); 
         * tenemos que llamar el metodo tableChanged de la tabla que queremos asiganarle
         * el TableModel. Esto es jTable1.tableChanged(new TableModelEvent(jTable1.getModel())) ;
         * Si usamos fireTableDataChanged no es necesario llamar el metodo tableChanged porque este
         * ya lo implementa
         */
        fireTableDataChanged();
    
    }  

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto a = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getModelo();
            case 1:
                return a.getMarca();
            case 2:
                return a.getAnio();
            case 3:
                return a.getColor();
            default:
                return null;
        }

    }

}
