/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7;

/**
 *
 * @author agenovez
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorBiblioteca gestor = new GestorBiblioteca();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("1. Agregar Libro Físico");
            System.out.println("2. Agregar Libro Digital");
            System.out.println("3. Registrar Usuario");
            System.out.println("4. Prestar Libro");
            System.out.println("5. Devolver Libro");
            System.out.println("6. Mostrar Usuarios");
            System.out.println("7. Mostrar Libros");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título del libro: ");
                    String tituloFisico = scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autorFisico = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anioFisico = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("ISBN: ");
                    String isbnFisico = scanner.nextLine();
                    System.out.print("Número de páginas: ");
                    int numPaginas = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Editorial: ");
                    String editorial = scanner.nextLine();

                    LibroFisico libroFisico = new LibroFisico(tituloFisico, autorFisico, anioFisico, isbnFisico, numPaginas, editorial);
                    gestor.agregarLibro(libroFisico);
                    System.out.println("Libro físico agregado con éxito.");
                    break;

                case 2:
                    System.out.print("Título del libro: ");
                    String tituloDigital = scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autorDigital = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anioDigital = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("ISBN: ");
                    String isbnDigital = scanner.nextLine();
                    System.out.print("Tamaño del archivo (MB): ");
                    double tamanoArchivo = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Formato: ");
                    String formato = scanner.nextLine();

                    LibroDigital libroDigital = new LibroDigital(tituloDigital, autorDigital, anioDigital, isbnDigital, tamanoArchivo, formato);
                    gestor.agregarLibro(libroDigital);
                    System.out.println("Libro digital agregado con éxito.");
                    break;

                case 3:
                    System.out.print("Nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("ID del usuario: ");
                    String idUsuario = scanner.nextLine();

                    Usuario usuario = new Usuario(nombreUsuario, idUsuario);
                    gestor.registrarUsuario(usuario);
                    System.out.println("Usuario registrado con éxito.");
                    break;

                case 4:
                    System.out.print("ISBN del libro a prestar: ");
                    String isbnPrestar = scanner.nextLine();
                    System.out.print("ID del usuario que solicita el libro: ");
                    String idUsuarioPrestar = scanner.nextLine();

                    if (gestor.prestarLibro(isbnPrestar, idUsuarioPrestar)) {
                        System.out.println("Préstamo realizado con éxito.");
                    } else {
                        System.out.println("No se pudo realizar el préstamo. Verifique el ISBN y el ID del usuario.");
                    }
                    break;

                case 5:
                    System.out.print("ISBN del libro a devolver: ");
                    String isbnDevolver = scanner.nextLine();
                    System.out.print("ID del usuario que devuelve el libro: ");
                    String idUsuarioDevolver = scanner.nextLine();

                    if (gestor.devolverLibro(isbnDevolver, idUsuarioDevolver)) {
                        System.out.println("Devolución realizada con éxito.");
                    } else {
                        System.out.println("No se pudo realizar la devolución. Verifique el ISBN y el ID del usuario.");
                    }
                    break;

                case 6:
                    System.out.println("--- Usuarios Registrados ---");
                    gestor.coleccionUsuarios.forEach((id, usr) -> {
                        System.out.println("ID: " + id + ", Nombre: " + usr.getNombre() + ", Libros Prestados: " + usr.getLibrosPrestados().size());
                    });
                    break;

                case 7:
                    System.out.println("--- Libros Registrados ---");
                    gestor.coleccionLibros.forEach((isbn, libro) -> {
                        System.out.println("ISBN: " + isbn + ", Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor());
                    });
                    break;

                case 8:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema de biblioteca!");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        scanner.close();
    }
}
