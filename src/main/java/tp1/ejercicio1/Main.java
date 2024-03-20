package tp1.ejercicio1;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Concurso literario = new Concurso("Concurso Literario", LocalDate.now(), LocalDate.now());
        Concurso belleza = new Concurso("Concurso de Belleza", LocalDate.now(), LocalDate.now());

        Participante pedro = new Participante("11111", "Pedro");
        Participante juan = new Participante("22222", "Juan");
        Participante maria = new Participante("33333", "Maria");
        Participante ana = new Participante("444444", "Ana");

        Inscripcion.inscribirAEn(pedro, literario);
        Inscripcion.inscribirAEn(juan, literario);
        Inscripcion.inscribirAEn(maria, literario);
        Inscripcion.inscribirAEn(maria, belleza);
        Inscripcion.inscribirAEn(ana, belleza);

        literario.mostrarInscriptos();
        belleza.mostrarInscriptos();
    }
}