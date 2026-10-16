/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Observer.IObservadorInscripcion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class ModeloInscripcion {
    private List<IObservadorInscripcion> observadores = new ArrayList<>();
    private List<Taller> talleresDisponibles;
    private Taller tallerSeleccionado;
    private Alumno alumnoActual;

    public ModeloInscripcion() {
        talleresDisponibles = new ArrayList<>();
        talleresDisponibles.add(new Taller("T-01", "Programación 3", "Ing. Carlos Pérez", "24 Oct 2026", "10:00 AM - 12:00 PM"));
        talleresDisponibles.add(new Taller("T-02", "Base de Datos Avanzada", "Mtra. Ana López", "25 Oct 2026", "04:00 PM - 06:00 PM"));
    }

    public void agregarObservador(IObservadorInscripcion obs) {
        observadores.add(obs);
    }

    public void cargarTalleres() {
        for (IObservadorInscripcion obs : observadores) {
            obs.actualizarListaTalleres(talleresDisponibles);
        }
    }

    public void seleccionarTaller(int indice) {
        if (indice >= 0 && indice < talleresDisponibles.size()) {
            tallerSeleccionado = talleresDisponibles.get(indice);
            for (IObservadorInscripcion obs : observadores) {
                obs.mostrarDetallesTaller(tallerSeleccionado.getDetallesCompletos());
            }
        }
    }

    public void iniciarInscripcion() {
        for (IObservadorInscripcion obs : observadores) {
            obs.solicitarIdAlumno();
        }
    }

    public void buscarAlumnoPorId(String id) {
        // Simulacion de base de datos
        if (id.equals("253244")) {
            alumnoActual = new Alumno(id, "Jesús Alfonso", "7to Semestre", "Ingeniería en Software");
            for (IObservadorInscripcion obs : observadores) {
                obs.mostrarDatosAlumno(alumnoActual.getDatosCompletos());
            }
        } else {
            for (IObservadorInscripcion obs : observadores) {
                obs.mostrarDatosAlumno("Alumno no encontrado.");
            }
        }
    }

    public void confirmarInscripcion() {
        if (tallerSeleccionado != null && alumnoActual != null) {
            String folio = "#" + (int)(Math.random() * 10000);
            Ticket ticket = new Ticket(folio, alumnoActual, tallerSeleccionado, LocalDateTime.MIN);
        
            for (IObservadorInscripcion obs : observadores){
                obs.mostrarTicketInscripcion(ticket.formatearParaPantalla());
            }    
        }
    }
}
