/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pooprojectv1;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author IrisCore7
 */
public class Pooprojectv1 {

    public static void main(String[] args){
        
        /*
            TEMAS DE INTERFAZ:
            Metal - javax.swing.plaf.metal.MetalLookAndFeel
            Nimbus - javax.swing.plaf.nimbus.NimbusLookAndFeel
            CDE/Motif - com.sun.java.swing.plaf.motif.MotifLookAndFeel
            Windows - com.sun.java.swing.plaf.windows.WindowsLookAndFeel
            Windows Classic - com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
        */
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
                
        MainWindow window = new MainWindow();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
