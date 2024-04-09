package tp1.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class FakeRegistroDeInscripcion implements RegistroDeInscripcion {
    private List<String> registros = new ArrayList<>();

    @Override
    public void registrar(String registro) {
        registros.add(registro);
    }

    public List<String> getRegistros() {
        return registros;
    }
}

