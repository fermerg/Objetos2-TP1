package tp1.ejercicio1;

import persistencia.EnBaseDatosRegistroDeInscripcion;
import persistencia.EnDiscoRegistroDeInscripcion;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Connection conexion = ConexionBD.obtenerConexion();

        Participante teo = new Participante("35.666.999", "Teo", "3", "teo@mail");
        Participante ana = new Participante("36.666.999", "Ana", "4", "ana@mail");
        Participante juan = new Participante("37.666.999", "Juan", "5", "juan@mail");
        Concurso robotica = new Concurso("Robotica",
                "999",
                LocalDate.now(),
                LocalDate.now().plusDays(30),
                new EnDiscoRegistroDeInscripcion(), new EmailSender());
        robotica.inscripcion(teo, LocalDate.now());

        Concurso ajedrez = new Concurso("Ajedrez",
                "998",
                LocalDate.now(),
                LocalDate.now().plusDays(30),
                new EnBaseDatosRegistroDeInscripcion(), new EmailSender());
        ajedrez.inscripcion(ana, LocalDate.now().plusDays(2));
        ajedrez.inscripcion(juan, LocalDate.now());
    }
}
