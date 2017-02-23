/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.evilinc.jhexeditor.gui;

import java.io.IOException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author teton
 */
public class EmptyByteArrayTableModel extends ByteArrayTableModel {

    private EmptyByteArrayTableModel(byte[] data) {
        super(data);
    }

    public EmptyByteArrayTableModel() {
        super(null);
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "No file loaded";
    }

    public void setNumberOfColumns(final int numberOfColumns) {
        // Not implemented
    }

}
