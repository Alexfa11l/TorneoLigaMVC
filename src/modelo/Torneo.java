package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Equipo> equipos;

    public Torneo() {
        this.equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    // Validación solicitada: verificar si el número de equipos es potencia de 2 (ej. 16, 8, 4, 2)
    public void validarNumeroEquipos() throws NumeroEquiposInvalidoException {
        int n = equipos.size();
        if (n <= 1 || (n & (n - 1)) != 0) {
            throw new NumeroEquiposInvalidoException("El número de equipos debe ser una potencia de 2 (ejemplo: 16, 8, 4). Actual: " + n);
        }
    }

    // Método recursivo para generar las llaves del torneo
    public void generarSorteoRecursivo(List<Equipo> listaEquipos) throws SorteoInvalidoException {
        if (listaEquipos == null || listaEquipos.isEmpty()) {
            throw new SorteoInvalidoException("No hay equipos suficientes para realizar el sorteo.");
        }
        
        // Caso base de la recursividad: cuando queda 1 ganador o se define la final
        if (listaEquipos.size() == 1) {
            System.out.println("¡Equipo campeón o fase final alcanzada por: " + listaEquipos.get(0).getNombre() + "!");
            return;
        }

        List<Equipo> siguienteFase = new ArrayList<>();
        System.out.println("\n--- Nueva ronda de enfrentamientos ---");
        
        for (int i = 0; i < listaEquipos.size(); i += 2) {
            Equipo e1 = listaEquipos.get(i);
            Equipo e2 = listaEquipos.get(i + 1);
            System.out.println(e1.getNombre() + " vs " + e2.getNombre());
            siguienteFase.add(e1); 
        }

        // Llamada recursiva para la siguiente ronda
        generarSorteoRecursivo(siguienteFase);
    }

    // Método para SERIALIZAR (Guardar el torneo en un archivo binario)
    public static void guardarTorneo(Torneo torneo, String rutaArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(torneo);
        }
    }

    // Método para DESERIALIZAR (Cargar el torneo desde el archivo binario)
    public static Torneo cargarTorneo(String rutaArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (Torneo) ois.readObject();
        }
    }
}