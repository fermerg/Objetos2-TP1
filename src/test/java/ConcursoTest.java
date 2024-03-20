import org.junit.jupiter.api.Test;
import tp1.ejercicio1.Concurso;
import tp1.ejercicio1.Inscripcion;
import tp1.ejercicio1.Participante;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    @Test
    public void testInscripcionValida(){
        Participante unParticipante = new Participante("34.666.999", "Manuel");
        Concurso concursoCiencia = new Concurso("Concurso de ciencias", LocalDate.of(2024, 3, 10), LocalDate.of(2024,3,15));
        Inscripcion.inscribirAEn(unParticipante,concursoCiencia);
        assertTrue(concursoCiencia.participanteInscripto(unParticipante));
        assertEquals(1, concursoCiencia.cantidadInscriptos());
    }

    @Test
    public void TestInscripcionPrimerDia(){
        Participante marta = new Participante("34.666.999", "Marta");
        Concurso concursoAjedrez = new Concurso("Concurso de ajedrez", LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 20));
        Inscripcion.inscribirAEn(marta, concursoAjedrez);
        assertTrue(concursoAjedrez.participanteInscripto(marta));
        //assertEquals(10, marta.getPuntaje());
        assertEquals(LocalDate.now(), concursoAjedrez.getFechaInicioInscripcion());
    }

    @Test
    public void TestInscripcionFueraDeRango(){
        Participante carlos = new Participante("33.666.999", "Carlos");
        Concurso concursoVoley = new Concurso("Concurso de voley", LocalDate.of(2024,3, 5), LocalDate.of(2024,3,30));
        Inscripcion.inscribirAEn(carlos, concursoVoley);
        assertTrue(concursoVoley.participanteInscripto(carlos));
    }
}

//Luego de implementar escriba los siguientes casos de test:
//1. Un participante se inscribe en un concurso
//2. Un participante se inscribe en un concurso el primer día de abierta la inscripción.
//3. Un participante intenta inscribirse fuera del rango de inscripción.
//Importante: Tener en cuenta el paso del tiempo en aquellos tests que verifican cuestiones
//relacionadas con la fecha.
//Lograr alta cobertura (mayor a 90%). Verifique si quedan funcionalidades sin testear.