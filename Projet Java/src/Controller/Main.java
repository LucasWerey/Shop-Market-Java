/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import View.WelcomeFrame;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        WelcomeFrame welcome = new WelcomeFrame();
        welcome.setVisible(true);
        welcome.setDefaultCloseOperation(WelcomeFrame.EXIT_ON_CLOSE);
      //  welcome.setBounds(0, 0, 1205, 650);
        welcome.setExtendedState(WelcomeFrame.MAXIMIZED_BOTH);
    }
} 
