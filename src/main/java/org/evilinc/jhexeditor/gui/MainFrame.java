/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.evilinc.jhexeditor.gui;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 *
 * @author teton
 */
public class MainFrame extends JFrame {

    private ByteArrayTable contentTable;
    private JScrollPane contentTableScrollPane;
    private JMenuBar menuBar;

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
        initializeMenuBar();
        initializeTable();
    }

    private void initializeTable() {
        contentTable = new ByteArrayTable("/tmp/test");
        contentTableScrollPane = new JScrollPane(contentTable);
    }

    private void initializeMenuBar() {
        menuBar = new JMenuBar();
        menuBar.add(getFileMenu());
        menuBar.add(getEditMenu());
        menuBar.add(getAboutMenu());
    }

    private JMenu getFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.add(getOpenAction());
        fileMenu.add(getSaveAction());
        fileMenu.addSeparator();
        fileMenu.add(getExitAction());
        return fileMenu;
    }

    private AbstractAction getOpenAction() {
        final AbstractAction openAction = new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser("~");
                fileChooser.setAcceptAllFileFilterUsed(true);
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                final int fileChooserChoice = fileChooser.showOpenDialog(MainFrame.this);
                if (fileChooserChoice == JFileChooser.APPROVE_OPTION) {
                    contentTable.openFile(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        };
        openAction.putValue(AbstractAction.SMALL_ICON, UIManager.getIcon("FileView.directoryIcon"));
        openAction.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
        openAction.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_O);
        openAction.setEnabled(true);
        return openAction;
    }

    private AbstractAction getSaveAction() {
        final AbstractAction saveAction = new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: To implement
                JOptionPane.showMessageDialog(MainFrame.this, "Coming soon !", "Feature not implemented yet", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        saveAction.putValue(AbstractAction.SMALL_ICON, UIManager.getIcon("FileView.floppyDriveIcon"));
        saveAction.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        saveAction.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_S);
        saveAction.setEnabled(false);
        return saveAction;
    }

    private AbstractAction getExitAction() {
        final AbstractAction exitAction = new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        exitAction.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
        exitAction.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_E);
        exitAction.setEnabled(false);
        return exitAction;
    }

    private JMenu getEditMenu() {
        final JMenu editMenu = new JMenu("Edit");
        editMenu.add(getPreferencesAction());
        return editMenu;
    }

    private AbstractAction getPreferencesAction() {
        final AbstractAction preferencesAction = new AbstractAction("Preferences") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, "Coming soon !", "Feature not implemented yet", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        preferencesAction.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_F);
        preferencesAction.setEnabled(true);
        return preferencesAction;
    }
    private JMenu getAboutMenu() {
        final JMenu aboutMenu = new JMenu("About");
        aboutMenu.add(getAboutAction());
        return aboutMenu;
    }

    private AbstractAction getAboutAction() {
        final AbstractAction aboutAction = new AbstractAction("JHexEditor") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainFrame.this, "This software is developped by TeToN.", "JHexEditor v1.0b", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        aboutAction.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_A);
        aboutAction.setEnabled(true);
        return aboutAction;
    }

    private void addComponents() {
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(contentTableScrollPane, BorderLayout.CENTER);
    }

}
