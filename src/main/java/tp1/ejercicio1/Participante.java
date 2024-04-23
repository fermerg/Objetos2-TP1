package tp1.ejercicio1;

import java.time.LocalDate;
import java.util.Objects;

public class Participante {
    private String dni;
    private String nombre;
    private String idParticipante;
    private String email;
    private int puntaje;

    public Participante(String dni, String nombre, String idParticipante, String email){
        this.dni = dni;
        this.nombre = nombre;
        this.idParticipante = idParticipante;
        this.email = email;
    }
    public void sumarPuntos(Concurso concurso) {
        if (concurso.getFechaInicioInscripcion().isEqual(LocalDate.now())) {
            this.puntaje += 10;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String idParticipante(){
        return idParticipante;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante other = (Participante) o;
        return Objects.equals(dni, other.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}