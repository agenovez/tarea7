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
public class LibroFisico extends Libro {
    private int numPaginas;
    private String editorial;

    // Constructor
    public LibroFisico(String titulo, String autor, int anioPublicacion, String isbn, int numPaginas, String editorial) {
        super(titulo, autor, anioPublicacion, isbn);
        this.numPaginas = numPaginas;
        this.editorial = editorial;
    }

    // Getters y Setters
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
