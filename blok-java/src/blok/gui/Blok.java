/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.gui;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import blok.interfaces.ISkinFactory;

/**
 *
 * @author sandroandrade
 */
public class Blok {

    	
    public static void main(String[] args) {
    	
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }
}
