package persistencia;

import tp1.ejercicio1.ConexionBD;
import tp1.ejercicio1.RegistroDeInscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class EnBaseDatosRegistroDeInscripcion implements RegistroDeInscripcion {
    Connection conexion = ConexionBD.obtenerConexion();
    @Override
    public void registrar(String registro) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String sql = "INSERT INTO inscripcion (fecha_inscripcion, id_participante, id_concurso) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                String[] datos = registro.split(",");
                statement.setString(1, datos[0].trim()); // Fecha de inscripción
                statement.setString(2, datos[1].trim()); // ID del participante
                statement.setString(3, datos[2].trim()); //ID concurso
                statement.addBatch();
                statement.executeBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
             try {
                 conexion.close();
             } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
}