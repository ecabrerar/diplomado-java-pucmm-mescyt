/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ecabrerar
 */
public abstract class AbstractTableModelStandard extends AbstractTableModel {

    private List<?> dataArray = new ArrayList<>();
    private final List<String> columnas = new ArrayList<>();

    public AbstractTableModelStandard(String[] nombreColumnas, List<?> data) {

        columnas.addAll(Arrays.asList(nombreColumnas));

        this.dataArray = data;
    }

    public AbstractTableModelStandard(String[] nombreColumnas) {

        columnas.addAll(Arrays.asList(nombreColumnas));
    }

    protected List<?> getData() {
        return dataArray;
    }

    public void setData(List<?> data) {
        this.dataArray = data;
    }

    public Object getRow(int row) {
        return dataArray.get(row);
    }

    @Override
    public int getRowCount() {
        return dataArray.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Debe sobreescribir este metodo");
    }

}
