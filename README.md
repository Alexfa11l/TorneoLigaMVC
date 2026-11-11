# Torneo de Liga - Sistema de Gestión (MVC)

Proyecto desarrollado bajo el Patrón Modelo-Vista-Controlador (MVC) en Java para la gestión, validación, simulación de sorteo recursivo y persistencia de un torneo.

## Estructura del Proyecto
El código fuente se encuentra organizado en el directorio `src` bajo los siguientes paquetes:
- modelo: Contiene las clases de entidad (Equipo, Torneo) y las excepciones personalizadas (NumeroEquiposInvalidoException, SorteoInvalidoException).
- vista: Contiene la interfaz interactiva por consola (Main.java).
- controlador: Contiene la lógica de coordinación entre la vista y el modelo (ControladorTorneo.java).

## Funcionalidades Principales
1. Registro y visualización de equipos participantes.
2. Validación mediante excepciones para asegurar que el número de equipos sea una potencia de 2 antes de iniciar el torneo.
3. Algoritmo de sorteo y simulación de enfrentamientos de manera recursiva hasta definir al campeón.
4. Persistencia de datos para guardar y cargar el estado del torneo mediante archivos binarios (torneo.ser).

## Requisitos de Ejecución
- Java Development Kit (JDK) instalado.
- Entorno de desarrollo integrado (IDE) compatible con proyectos Java, como Eclipse IDE.

## Instrucciones para el Profesor / Evaluador
1. Clonar el repositorio en la máquina local mediante Git Bash:
   git clone https://github.com/Alexfa11l/TorneoLigaMVC.git
2. Abrir el IDE (Eclipse) e importar el proyecto como un proyecto Java existente.
3. Localizar la clase principal en el paquete vista: src/vista/Main.java.
4. Ejecutar la aplicación como Java Application para interactuar con el menú de consola.
