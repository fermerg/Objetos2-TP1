package tp1.ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private List<Inscripcion> listaInscriptos;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        this.nombre = nombre;
        this.listaInscriptos = new ArrayList<Inscripcion>();
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }
    public void nuevaInscripcion(Inscripcion inscripcion) {
         if(this.concursoAbierto())
             this.listaInscriptos.add(inscripcion);
         else System.out.println("La inscripcion a este concurso no esta disponible en esta fecha.");;
    }
    public boolean participanteInscripto(Participante participante){
        return this.listaInscriptos.stream().anyMatch(inscripcion -> inscripcion.estaInscripto(participante));
    }
    public int cantidadInscriptos(){
        return this.listaInscriptos.size();
    }
    public boolean concursoAbierto() {
        LocalDate fechaHoy = LocalDate.now();
        return !fechaHoy.isBefore(fechaInicioInscripcion) && !fechaHoy.isAfter(fechaFinInscripcion);
    }
    public LocalDate getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void mostrarInscriptos(){
        for(Inscripcion inscripto: this.listaInscriptos){
            //if(inscripto.estaInscripto(participante)){
            System.out.println(inscripto.toString());
        }
    }
}

//El participante debe poder inscribirse a los concursos. El concurso acepta la
//inscripción solo dentro del rango de fecha de inscripción. El participante gana 10 puntos si se
//inscribe durante el primer día de abierta la inscripción. Dado un participante se puede conocer la
//cantidad de puntos ganados. Si un participante intenta inscribirse fuera de la fecha de inscripción
//se debe informar con un mensaje
