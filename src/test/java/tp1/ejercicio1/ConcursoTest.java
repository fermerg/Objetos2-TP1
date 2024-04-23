package tp1.ejercicio1;

import org.junit.jupiter.api.Test;
import persistencia.EnDiscoRegistroDeInscripcion;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    LocalDate fechaInicio = LocalDate.of(2024, 4, 22);
    LocalDate fechaFin = LocalDate.of(2024, 5, 1);
    @Test
    public void testInscripcionValida(){
        Participante unParticipante = new Participante("32.666.999", "Manuel", "000", "unmail@mail");
        Concurso concursoCiencia = new Concurso("Concurso de ciencias", "999",
                LocalDate.now(), LocalDate.now().plusDays(15),
                new EnDiscoRegistroDeInscripcion(), new EmailSender());
        concursoCiencia.inscripcion(unParticipante, LocalDate.now());
        assertTrue(concursoCiencia.participanteInscripto(unParticipante));
        assertEquals(1, concursoCiencia.cantidadInscriptos());
    }
    @Test
    public void testInscripcionValidaFake(){
        Participante unParticipante = new Participante("32.666.999", "Manuel", "000", "manuel@mail");
        FakeRegistroDeInscripcion registro = new FakeRegistroDeInscripcion();
        FakeEmailSender email = new FakeEmailSender();
        Concurso concursoCiencia = new Concurso("Concurso de ciencias", "999",
                LocalDate.now(), LocalDate.now().plusDays(15),
                registro, email);
        concursoCiencia.inscripcion(unParticipante, LocalDate.now());
        assertEquals("22/04/2024, 000, 999", registro.getRegistros().get(0));
        assertEquals("manuel@mail", email.correos().toString());
    }
    @Test
    public void TestInscripcionPrimerDia(){
        FakeRegistroDeInscripcion reg = new FakeRegistroDeInscripcion();
        Participante marta = new Participante("33.666.999", "Marta", "001", "marta@mail");
        Concurso concursoAjedrez = new Concurso("Concurso de ajedrez", "998",
                fechaInicio, fechaFin, reg, new FakeEmailSender());
        concursoAjedrez.inscripcion(marta, fechaInicio);
        assertTrue(concursoAjedrez.participanteInscripto(marta));
        assertEquals(LocalDate.of(2024,4,22) , concursoAjedrez.getFechaInicioInscripcion());
    }

    @Test //preguntar
    public void TestInscripcionFueraDeRango(){
        Participante carlos = new Participante("34.666.999", "Carlos", "002", "carlos@mail");
        FakeRegistroDeInscripcion reg = new FakeRegistroDeInscripcion();
        Concurso concursoVoley = new Concurso("Concurso de voley",
                "997", LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(7),
                reg, new FakeEmailSender());

        assertThrows(RuntimeException.class, () -> concursoVoley.inscripcion(carlos, LocalDate.now()));
    }
}