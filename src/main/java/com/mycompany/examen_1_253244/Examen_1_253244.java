/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen_1_253244;

import Controlador.ControladorInscripcion;
import Entidades.ModeloInscripcion;
import Entidades.Alumno;
import Vista.VistaInscripcion;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jesús
 */
public class Examen_1_253244 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModeloInscripcion modelo = new ModeloInscripcion();
            VistaInscripcion vista = new VistaInscripcion();
            
            new ControladorInscripcion(vista, modelo);

            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
    }
}
