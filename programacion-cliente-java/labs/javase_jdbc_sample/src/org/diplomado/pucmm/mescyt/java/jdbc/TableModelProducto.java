/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.java.jdbc;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.diplomado.pucmm.mescyt.java.jdbc.encapsulados.Producto;

/**
 *
 * @author ecabrerar
 */
public class TableModelProducto extends AbstractTableModel {

    String[] columnas = {"Id", "Descripcion", "Cantidad"}; //Columnas
    List<Producto> data;

    public TableModelProducto() {

        ManejadorProducto mProducto = new ManejadorProducto();
        data = mProducto.getListadoProducto();  //Cargando los datos
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getDescripcion();
            case 2:
                return p.getCantidad();
            default:
                return null;

        }
    }

}
