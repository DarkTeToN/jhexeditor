/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.evilinc.jhexeditor.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author teton
 */
public class MainFrame extends JFrame {

    private ByteArrayTable contentTable;
    private JScrollPane contentTableScrollPane;

    public MainFrame() throws HeadlessException {
        super();
        initFrame();
    }

    private void initFrame() {
        initializeJFrameProperties();
        initializeLayoutManager();
        initializeComponents();
        addComponents();
    }

    private void initializeJFrameProperties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
    }

    private void initializeLayoutManager() {
        getContentPane().setLayout(new BorderLayout());
    }

    private void initializeComponents() {
        contentTable = new ByteArrayTable("/tmp/test");
        contentTableScrollPane = new JScrollPane(contentTable);
    }

    private void addComponents() {
        getContentPane().add(contentTableScrollPane);
    }

}
