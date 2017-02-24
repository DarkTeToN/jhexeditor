/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.evilinc.jhexeditor.gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JTable;

/**
 *
 * @author teton
 */
public class ByteArrayTable extends JTable {

    private ByteArrayTableModel model;

    public ByteArrayTable() {
    }
    
    public ByteArrayTable(final String fileToOpen) {
        super();
        openFile(fileToOpen);
    }
    
    public void setNumberOfColumns(final int numberOfColumns) {
        model.setNumberOfColumns(numberOfColumns);
    }

    private void setTableModel(final ByteArrayTableModel tableModelToSet) {
        if (tableModelToSet == null) {
            model = new EmptyByteArrayTableModel();
        } else {
            model = tableModelToSet;
        }
        setModel(model);
    }
    
    public final void openFile(final String fileToOpen) {
        try {
            final byte[] data = Files.readAllBytes(Paths.get(fileToOpen));
            setTableModel(new ByteArrayTableModel(data));
        } catch (IOException ex) {
            setModel(new EmptyByteArrayTableModel());
        }
    }
}
