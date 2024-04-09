package tp1.ejercicio1;

import org.junit.jupiter.api.Test;
import persistencia.EnBaseDatosRegistroDeInscripcion;
import persistencia.EnDiscoRegistroDeInscripcion;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    @Test
    public void testInscripcionValida(){
        Participante unParticipante = new Participante("32.666.999", "Manuel", "000");
        Concurso concursoCiencia = new Concurso("Concurso de ciencias", "999",
                LocalDate.now(), LocalDate.now().plusDays(15),
                new EnDiscoRegistroDeInscripcion());
        Inscripcion.inscribirAEn(unParticipante,concursoCiencia);
        assertTrue(concursoCiencia.participanteInscripto(unParticipante));
        assertEquals(1, concursoCiencia.cantidadInscriptos());
    }
    @Test
    public void testInscripcionValidaFake(){
        Participante unParticipante = new Participante("32.666.999", "Manuel", "000");
        FakeRegistroDeInscripcion registro = new FakeRegistroDeInscripcion();
        Concurso concursoCiencia = new Concurso("Concurso de ciencias", "999",
                LocalDate.now(), LocalDate.now().plusDays(15),
                registro);
        Inscripcion.inscribirAEn(unParticipante,concursoCiencia);
        assertTrue(concursoCiencia.participanteInscripto(unParticipante));
        assertEquals(1, concursoCiencia.cantidadInscriptos());
        assertEquals("04/04/2024, 000, 999", registro.getRegistros().get(0));
    }
    @Test
    public void TestInscripcionPrimerDia(){
        Participante marta = new Participante("33.666.999", "Marta", "001");
        Concurso concursoAjedrez = new Concurso("Concurso de ajedrez", "998",
                LocalDate.now(), LocalDate.now().plusDays(30),
                new EnDiscoRegistroDeInscripcion());
        Inscripcion.inscribirAEn(marta, concursoAjedrez);
        assertTrue(concursoAjedrez.participanteInscripto(marta));
        assertEquals(LocalDate.now(), concursoAjedrez.getFechaInicioInscripcion());
    }

    @Test //preguntar
    public void TestInscripcionFueraDeRango(){
        Participante carlos = new Participante("34.666.999", "Carlos", "002");
        Concurso concursoVoley = new Concurso("Concurso de voley",
                "997", LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(7),
                new EnDiscoRegistroDeInscripcion());
        Inscripcion.inscribirAEn(carlos, concursoVoley);
        assertThrows(RuntimeException.class, () -> {
            concursoVoley.participanteInscripto(carlos);
        });
        assertFalse(concursoVoley.participanteInscripto(carlos));
    }
    @Test
    public void TestInscripcionesEnBD(){
        Participante teo = new Participante("35.666.999", "Teo", "3");
        Participante ana = new Participante("36.666.999", "Ana", "4");
        Participante juan = new Participante("37.666.999", "Juan", "5");
        Concurso robotica = new Concurso("Robotica", "999",
                LocalDate.now(), LocalDate.now().plusDays(30),
                new EnBaseDatosRegistroDeInscripcion());
        Inscripcion.inscribirAEn(teo, robotica);
        Inscripcion.inscribirAEn(ana, robotica);
        Inscripcion.inscribirAEn(juan, robotica);
    }
}