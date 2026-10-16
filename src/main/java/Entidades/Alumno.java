/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Jesús
 */
public class Alumno {
    private String id;
    private String nombre;
    private String semestre;
    private String programa;

    public Alumno(String id, String nombre, String semestre, String programa) {
        this.id = id; this.nombre = nombre; 
        this.semestre = semestre; this.programa = programa;
    }

    public String getDatosCompletos() {
        return "ID: " + id + "\n" +
               "Nombre: " + nombre + "\n" +
               "Semestre: " + semestre + "\n" +
               "Programa: " + programa;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
}
