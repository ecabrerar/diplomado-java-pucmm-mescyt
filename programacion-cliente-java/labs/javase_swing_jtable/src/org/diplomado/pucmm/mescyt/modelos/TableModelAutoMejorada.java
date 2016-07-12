/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.modelos;

import java.util.Arrays;
import org.diplomado.pucmm.mescyt.Auto;
import org.diplomado.pucmm.mescyt.Color;
import org.diplomado.pucmm.mescyt.Marca;

/**
 *
 * @author ecabrerar
 */
public class TableModelAutoMejorada extends AbstractTableModelStandard {

    public TableModelAutoMejorada() {
        super(new String[]{"Modelo", "Marca", "Año", "Color"});

        super.setData(Arrays.asList(new Auto("Camry", Marca.TOYOTA, 2009, Color.ROJO),
                                   new Auto("Accord", Marca.HONDA, 2007, Color.NEGRO)));

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto a = (Auto) getData().get(rowIndex);

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
