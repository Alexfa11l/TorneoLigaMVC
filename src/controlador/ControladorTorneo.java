package controlador;

import modelo.Equipo;
import modelo.NumeroEquiposInvalidoException;
import modelo.SorteoInvalidoException;
import modelo.Torneo;
import java.io.IOException;

public class ControladorTorneo {
    private Torneo torneo;

    public ControladorTorneo() {
        this.torneo = new Torneo();
    }

    public void agregarEquipo(String nombre) {
        torneo.agregarEquipo(new Equipo(nombre));
    }

    public void validarTorneo() throws NumeroEquiposInvalidoException {
        torneo.validarNumeroEquipos();
    }

    public void simularSorteo() throws SorteoInvalidoException {
        torneo.generarSorteoRecursivo(torneo.getEquipos());
    }

    public void guardar(String ruta) throws IOException {
        Torneo.guardarTorneo(torneo, ruta);
    }

    public void cargar(String ruta) throws IOException, ClassNotFoundException {
        this.torneo = Torneo.cargarTorneo(ruta);
    }

    public Torneo getTorneo() {
        return torneo;
    }
}