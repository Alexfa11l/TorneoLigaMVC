package vista;

import controlador.ControladorTorneo;
import modelo.NumeroEquiposInvalidoException;
import modelo.SorteoInvalidoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorTorneo controlador = new ControladorTorneo();
        int opcion = 0;

        do {
            System.out.println("\n--- GESTIÓN DE TORNEO DE LIGA (MVC) ---");
            System.out.println("1. Agregar equipo");
            System.out.println("2. Ver equipos");
            System.out.println("3. Validar número de equipos (Potencia de 2)");
            System.out.println("4. Simular sorteo recursivo");
            System.out.println("5. Guardar torneo en archivo");
            System.out.println("6. Cargar torneo desde archivo");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del equipo: ");
                        String nombre = scanner.nextLine();
                        controlador.agregarEquipo(nombre);
                        System.out.println("¡Equipo agregado con éxito!");
                        break;
                    case 2:
                        System.out.println("\nEquipos inscritos:");
                        for (var eq : controlador.getTorneo().getEquipos()) {
                            System.out.println("- " + eq.getNombre());
                        }
                        break;
                    case 3:
                        try {
                            controlador.validarTorneo();
                            System.out.println("¡Validación exitosa! El número de equipos es potencia de 2.");
                        } catch (NumeroEquiposInvalidoException e) {
                            System.out.println("Error de validación: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            controlador.validarTorneo(); // Valida que sea potencia de 2 antes del sorteo
                            controlador.simularSorteo();
                        } catch (NumeroEquiposInvalidoException | SorteoInvalidoException e) {
                            System.out.println("Error en el sorteo: " + e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            controlador.guardar("torneo.ser");
                            System.out.println("Torneo guardado correctamente en torneo.ser");
                        } catch (Exception e) {
                            System.out.println("Error al guardar: " + e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            controlador.cargar("torneo.ser");
                            System.out.println("Torneo cargado correctamente desde torneo.ser");
                        } catch (Exception e) {
                            System.out.println("Error al cargar: " + e.getMessage());
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        } while (opcion != 7);

        scanner.close();
    }
}