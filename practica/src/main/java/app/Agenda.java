package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    static class Tarea {
        String descripcion;
        boolean completada;

        public Tarea(String descripcion) {
            this.descripcion = descripcion;
            this.completada = false;
        }

        public void completar() {
            completada = true;
        }

        @Override
        public String toString() {
            return (completada ? "[✓] " : "[ ] ") + descripcion;
        }
    }

    private static ArrayList<Tarea> tareas = new ArrayList<>();

    public static void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
    }

    public static void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).completar();
        }
    }

    public static void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        }
    }

    public static int totalTareas() {
        return tareas.size();
    }

    public static void limpiarTareas() {
        tareas.clear();
    }

    public static boolean estaCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            return tareas.get(indice).completada;
        }
        return false;
    }

    public static void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }

        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = System.getenv("USER_NAME");
        if (user == null) user = "Usuario";

        while (true) {
            System.out.println("=================================================");
            System.out.println(" ORGANIZADOR DE TAREAS - [Usuario: " + user + "]");
            System.out.println("=================================================");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Ejecutar pruebas");
            System.out.println("6. Salir");
            System.out.println("=================================================");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripción de la tarea: ");
                    String desc = scanner.nextLine();
                    agregarTarea(desc);
                    break;

                case 2:
                    listarTareas();
                    break;

                case 3:
                    listarTareas();
                    System.out.print("Número de tarea a completar: ");
                    int comp = scanner.nextInt() - 1;
                    completarTarea(comp);
                    break;

                case 4:
                    listarTareas();
                    System.out.print("Número de tarea a eliminar: ");
                    int elim = scanner.nextInt() - 1;
                    eliminarTarea(elim);
                    break;

                case 5:
                    System.out.println("Ejecuta las pruebas con: mvn test");
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}