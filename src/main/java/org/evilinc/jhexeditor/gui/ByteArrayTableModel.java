/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.evilinc.jhexeditor.gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author teton
 */
public class ByteArrayTableModel extends AbstractTableModel {

    private int numberOfColumns = 30;
    private final byte[] data;

    public ByteArrayTableModel(final byte[] data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return (int) (data.length / numberOfColumns + 1);
    }

    @Override
    public int getColumnCount() {
        return numberOfColumns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final int oneDimensionIndex = (rowIndex * numberOfColumns) + columnIndex;
        if (oneDimensionIndex < data.length) {
            return String.format("%02X", data[oneDimensionIndex]);
        }
        return "";
    }

    public void setNumberOfColumns(final int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
        fireTableStructureChanged();
    }

}
