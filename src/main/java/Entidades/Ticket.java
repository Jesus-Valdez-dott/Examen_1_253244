/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jesús
 */
public class Ticket {
    private String folio;
    private Alumno alumno;
    private Taller taller;
    private LocalDateTime fechaGeneracion;

    public Ticket(String folio, Alumno alumno, Taller taller, LocalDateTime fechaGeneracion) {
        this.folio = folio;
        this.alumno = alumno;
        this.taller = taller;
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getFolio() {
        return folio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Taller getTaller() {
        return taller;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }
    
    
    public String formatearParaPantalla(){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "=====================================\n"
             + "TICKET DE INSCRIPCION"
             + "=====================================\n"
             + "Folio: " + folio + "\n"
             + "Fecha: " + fechaGeneracion.format(formatoFecha) + "\n"
             + "Alumno: " + alumno.getNombre() + " (ID:" + alumno.getId() + ")\n"
             + taller.getDetallesCompletos()
             + "=====================================";
    }
}
