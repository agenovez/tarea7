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
import java.util.HashMap;

public class GestorBiblioteca {
    public HashMap<String, Libro> coleccionLibros;
    public HashMap<String, Usuario> coleccionUsuarios;

    // Constructor
    public GestorBiblioteca() {
        coleccionLibros = new HashMap<>();
        coleccionUsuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        coleccionLibros.put(libro.getIsbn(), libro);
    }

    public void registrarUsuario(Usuario usuario) {
        coleccionUsuarios.put(usuario.getId(), usuario);
    }

    public boolean prestarLibro(String isbn, String userId) {
        if (coleccionLibros.containsKey(isbn) && coleccionUsuarios.containsKey(userId)) {
            Usuario usuario = coleccionUsuarios.get(userId);
            usuario.agregarLibro(coleccionLibros.get(isbn));
            return true;
        }
        return false;
    }

    public boolean devolverLibro(String isbn, String userId) {
        if (coleccionUsuarios.containsKey(userId)) {
            Usuario usuario = coleccionUsuarios.get(userId);
            return usuario.getLibrosPrestados().removeIf(libro -> libro.getIsbn().equals(isbn));
        }
        return false;
    }
}

