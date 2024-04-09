package persistencia;

import tp1.ejercicio1.RegistroDeInscripcion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnDiscoRegistroDeInscripcion implements RegistroDeInscripcion {
    @Override
    public void registrar(String registro) {
        File rutaArchivo = new File("/Users/fm/Desktop/inscripciones.txt");
        try (FileWriter writer = new FileWriter(rutaArchivo, true)) {
            writer.write("fecha, id_participante, id_concurso" + System.lineSeparator());
            writer.write(registro + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("No se pudo persistir", e);
        }
    }
}