package tp1.ejercicio1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private String idConcurso;
    private List<Inscripcion> listaInscriptos;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private RegistroDeInscripcion registro;
    private EmailSender emailSender;

    public Concurso(String nombre, String idConcurso, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion, RegistroDeInscripcion registro) {
        this.nombre = nombre;
        this.idConcurso = idConcurso;
        this.listaInscriptos = new ArrayList<>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
        this.registro = registro;
        this.emailSender = new EmailSender();
    }
    public void inscripcion(Inscripcion inscripcion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (!this.concursoAbierto()) {
            throw new RuntimeException("La inscripcion a este concurso no esta disponible en esta fecha.");
        }
        this.listaInscriptos.add(inscripcion);

        String datos = (inscripcion.getFecha().format(formatter) + ", " + inscripcion.getParticipanteId() + ", " + this.idConcurso);
        System.out.println(datos);
        this.registro.registrar(datos);
        emailSender.enviarEmail();
    }
    public boolean participanteInscripto(Participante participante){
        return this.listaInscriptos.stream().anyMatch(inscripcion -> inscripcion.estaInscripto(participante));
    }
    public int cantidadInscriptos(){
        return this.listaInscriptos.size();
    }
    private boolean concursoAbierto() {
        LocalDate fechaHoy = LocalDate.now();
        return !fechaHoy.isBefore(fechaInicioInscripcion) && !fechaHoy.isAfter(fechaFinInscripcion);
    }

    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }
}

