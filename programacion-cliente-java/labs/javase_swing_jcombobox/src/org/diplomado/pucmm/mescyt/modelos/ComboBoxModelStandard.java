/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diplomado.pucmm.mescyt.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ecabrerar
 */
public class ComboBoxModelStandard<T> extends AbstractListModel implements ComboBoxModel {

    private List<T> dataArray = new ArrayList<>();

    public ComboBoxModelStandard() {    }       

    public ComboBoxModelStandard(List<T> data) {
        this.dataArray = data;
    }    
    

    /**
     * The current selected object.
     */
    protected Object selectedObject;

    // implementation of javax.swing.ComboBoxModel
    /**
     * Set the value of the selected item. The selected item may be null.
     * <p>
     * @param anObject The combo box value or null for no selection.
     */
    @Override
    public void setSelectedItem(Object anObject) {
        if ((selectedObject != null && !selectedObject.equals(anObject))
                || selectedObject == null && anObject != null) {
            selectedObject = anObject;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedObject;
    }

    @Override
    public int getSize() {
        return dataArray.size();
    }

    @Override
    public Object getElementAt(int index) {
        return dataArray.get(index);
    }

    public T getData(int index) {
        return dataArray.get(index);
    }

    public void setData(List<T> dataArray) {
        this.dataArray = dataArray;
    }    
    

}
