/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Entidades.Taller;
import Observer.IObservadorInscripcion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jesús
 */
public class VistaInscripcion extends JFrame implements IObservadorInscripcion {
    // Componentes expuestos para el Controlador
    DefaultListModel<String> modeloLista;
    JList<String> listaTalleres;
    JButton btnSolicitar;
    JTextField txtIdAlumno;
    JButton btnBuscarId;
    JButton btnConfirmar;

    // Componentes internos de la vista
    private JTextArea areaDetallesTaller;
    private JPanel panelInferior;
    private JTextArea areaDatosInferior;

    public VistaInscripcion() {
        setTitle("Sistema ITSON - Semana de ISW");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2, 10, 10));

        // a. Lista de talleres a la izquierda
        modeloLista = new DefaultListModel<>();
        listaTalleres = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaTalleres);
        scrollLista.setBorder(new TitledBorder("Talleres Disponibles"));

        // b. Detalles a la derecha
        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));
        panelDerecho.setBorder(new TitledBorder("Detalles del Taller"));
        areaDetallesTaller = new JTextArea();
        areaDetallesTaller.setEditable(false);
        btnSolicitar = new JButton("Solicitar Inscribirse");
        btnSolicitar.setEnabled(false);

        panelDerecho.add(new JScrollPane(areaDetallesTaller), BorderLayout.CENTER);
        panelDerecho.add(btnSolicitar, BorderLayout.SOUTH);

        panelSuperior.add(scrollLista);
        panelSuperior.add(panelDerecho);
        add(panelSuperior, BorderLayout.CENTER);

        // c y d. Zona Inferior (Datos y Ticket)
        panelInferior = new JPanel(new BorderLayout(5, 5));
        panelInferior.setBorder(new TitledBorder("Validación / Ticket"));
        
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBusqueda.add(new JLabel("ID del Alumno:"));
        txtIdAlumno = new JTextField(15);
        btnBuscarId = new JButton("Buscar");
        panelBusqueda.add(txtIdAlumno);
        panelBusqueda.add(btnBuscarId);

        areaDatosInferior = new JTextArea(6, 40);
        areaDatosInferior.setEditable(false);
        
        btnConfirmar = new JButton("Confirmar Inscripción");
        btnConfirmar.setEnabled(false);
        JPanel panelBotonConfirmar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonConfirmar.add(btnConfirmar);

        panelInferior.add(panelBusqueda, BorderLayout.NORTH);
        panelInferior.add(new JScrollPane(areaDatosInferior), BorderLayout.CENTER);
        panelInferior.add(panelBotonConfirmar, BorderLayout.SOUTH);
        
        panelInferior.setVisible(false);
        add(panelInferior, BorderLayout.SOUTH);
    }

    @Override
    public void actualizarListaTalleres(List<Taller> talleres) {
        modeloLista.clear();
        for (Taller t : talleres) {
            modeloLista.addElement(t.getNombreLista());
        }
    }

    @Override
    public void mostrarDetallesTaller(String detalles) {
        areaDetallesTaller.setText(detalles);
        btnSolicitar.setEnabled(true);
        panelInferior.setVisible(false);
    }

    @Override
    public void solicitarIdAlumno() {
        panelInferior.setVisible(true);
        areaDatosInferior.setText("");
        txtIdAlumno.setText("");
        btnConfirmar.setEnabled(false);
        txtIdAlumno.requestFocus();
    }

    @Override
    public void mostrarDatosAlumno(String datosAlumno) {
        areaDatosInferior.setText("DATOS DEL ALUMNO:\n" + datosAlumno);
        btnConfirmar.setEnabled(!datosAlumno.contains("no encontrado"));
    }

    @Override
    public void mostrarTicketInscripcion(String ticket) {
        areaDatosInferior.setText(ticket);
        btnConfirmar.setEnabled(false);
        btnBuscarId.setEnabled(false);
        txtIdAlumno.setEnabled(false);
    }
    
    // --- GETTERS PARA EL CONTROLADOR ---
    public JList<String> getListaTalleres() {
        return listaTalleres;
    }

    public JButton getBtnSolicitar() {
        return btnSolicitar;
    }

    public JTextField getTxtIdAlumno() {
        return txtIdAlumno;
    }

    public JButton getBtnBuscarId() {
        return btnBuscarId;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }
}
