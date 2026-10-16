/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observer;


import Entidades.Taller;
import java.util.List;

/**
 *
 * @author Jesús
 */
public interface IObservadorInscripcion {
    void actualizarListaTalleres(List<Taller> talleres);
    void mostrarDetallesTaller(String detalles);
    void solicitarIdAlumno();
    void mostrarDatosAlumno(String datosAlumno);
    void mostrarTicketInscripcion(String ticket);
}
