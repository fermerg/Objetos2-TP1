package tp1.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/oop2_tp2";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection obtenerConexion() {
        try{
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
