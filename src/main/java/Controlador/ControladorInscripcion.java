/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Entidades.ModeloInscripcion;
import Vista.VistaInscripcion;

/**
 *
 * @author Jesús
 */
public class ControladorInscripcion {
    private VistaInscripcion vista;
    private ModeloInscripcion modelo;

    public ControladorInscripcion(VistaInscripcion vista, ModeloInscripcion modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.modelo.agregarObservador(this.vista);

        inicializarEventos();

        this.modelo.cargarTalleres();
    }

    private void inicializarEventos() {
        vista.getListaTalleres().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = vista.getListaTalleres().getSelectedIndex();
                modelo.seleccionarTaller(index);
            }
        });
        vista.getBtnSolicitar().addActionListener(e -> {
            modelo.iniciarInscripcion();
        });
        vista.getBtnBuscarId().addActionListener(e -> {
            String id = vista.getTxtIdAlumno().getText().trim();
            if (!id.isEmpty()) {
                modelo.buscarAlumnoPorId(id);
            }
        });
        vista.getBtnConfirmar().addActionListener(e -> {
            modelo.confirmarInscripcion();
        });
    }
}
