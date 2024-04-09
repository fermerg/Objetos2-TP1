package tp1.ejercicio1;

import persistencia.EnBaseDatosRegistroDeInscripcion;
import persistencia.EnDiscoRegistroDeInscripcion;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Connection conexion = ConexionBD.obtenerConexion();

        Participante teo = new Participante("35.666.999", "Teo", "3");
        Participante ana = new Participante("36.666.999", "Ana", "4");
        Participante juan = new Participante("37.666.999", "Juan", "5");
        Concurso robotica = new Concurso("Robotica",
                "999",
                LocalDate.now(),
                LocalDate.now().plusDays(30),
                new EnDiscoRegistroDeInscripcion());
        Inscripcion.inscribirAEn(teo, robotica);
        Inscripcion.inscribirAEn(ana, robotica);
        Inscripcion.inscribirAEn(juan, robotica);

        Concurso ajedrez = new Concurso("Ajedrez",
                "998",
                LocalDate.now(),
                LocalDate.now().plusDays(30),
                new EnBaseDatosRegistroDeInscripcion());
    }
}
