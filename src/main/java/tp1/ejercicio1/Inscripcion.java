package tp1.ejercicio1;

import java.time.LocalDate;

public class Inscripcion {
    private LocalDate fecha;
    private Participante participante;
    private Concurso concurso;

    public Inscripcion(LocalDate fecha, Participante participante, Concurso concurso){
        this.fecha = fecha;
        this.concurso = concurso;
        this.participante = participante;
    }
    public static void inscribirAEn(Participante participante, Concurso concurso){
        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), participante, concurso);
        concurso.inscripcion(inscripcion);
        participante.sumarPuntos(concurso);
    }
    public boolean estaInscripto(Participante participante){
        return this.participante.equals(participante);
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public String getParticipanteId(){
        return participante.getIdParticipante();
    }
    @Override
    public String toString() {
        return "Participante(s) inscripto(s): " + participante.getNombre();
    }
}