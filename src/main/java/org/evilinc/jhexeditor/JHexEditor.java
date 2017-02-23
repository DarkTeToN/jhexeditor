/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.evilinc.jhexeditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.evilinc.jhexeditor.gui.MainFrame;

/**
 *
 * @author teton
 */
public class JHexEditor {

    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    private static void printFileToHexadecimal(final String filetToPrintInHex) throws IOException {
        System.out.println(filetToPrintInHex);
        byte[] byteArray = Files.readAllBytes(Paths.get(filetToPrintInHex));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < byteArray.length; i++) {
            if (i % 30 == 0) {
                sb.append('\n');
            }
            sb.append(String.format("%02X ", byteArray[i]));
        }
        System.out.println(sb.toString());
    }

}
