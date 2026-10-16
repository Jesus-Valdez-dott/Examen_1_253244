/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Jesús
 */
public class Taller {
    private String id;
    private String nombre;
    private String instructor;
    private String fecha;
    private String horario;

    public Taller(String id, String nombre, String instructor, String fecha, String horario) {
        this.id = id; this.nombre = nombre; this.instructor = instructor;
        this.fecha = fecha; this.horario = horario;
    }

    public String getNombreLista() { return id + ": " + nombre; }
    
    public String getDetallesCompletos() {
        return "Nombre completo: " + nombre + "\n" +
               "Instructor: " + instructor + "\n" +
               "Fecha del taller: " + fecha + "\n" +
               "Horario: " + horario;
    }
}
