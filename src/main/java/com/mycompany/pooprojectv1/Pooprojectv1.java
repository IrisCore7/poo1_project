/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pooprojectv1;

import com.mycompany.pooprojectv1.estudiante.Alumno;
import com.mycompany.pooprojectv1.universidad.MatriculaUniversidad;
import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author IrisCore7
 */
public class Pooprojectv1 {

    public static void main(String[] args) throws ParseException {
        
        /*
            TEMAS DE INTERFAZ:
            Metal - javax.swing.plaf.metal.MetalLookAndFeel
            Nimbus - javax.swing.plaf.nimbus.NimbusLookAndFeel
            CDE/Motif - com.sun.java.swing.plaf.motif.MotifLookAndFeel
            Windows - com.sun.java.swing.plaf.windows.WindowsLookAndFeel
            Windows Classic - com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
        */
        
        Alumno alumno = new Alumno(
            "A20251234",                   // código
            "Carlos",                      // nombres
            "Gonzales Ramos",             // apellidos
            "carlos.gonzales@uni.edu.pe"  // correo
        );

        
        MatriculaUniversidad matriculaUniversidad = new MatriculaUniversidad("03/06/25 08:30:00", "30/06/25 18:30:00", 264.99);
        
        ChatBot chatbot = new ChatBot("Hanna", matriculaUniversidad, alumno);
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
                
        MainWindow window = new MainWindow();
        window.addChatbot(chatbot); // agregamos el chatbot
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
