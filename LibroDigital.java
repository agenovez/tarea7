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
public class LibroDigital extends Libro {
    private double tamanoArchivo;
    private String formato;

    // Constructor
    public LibroDigital(String titulo, String autor, int anioPublicacion, String isbn, double tamanoArchivo, String formato) {
        super(titulo, autor, anioPublicacion, isbn);
        this.tamanoArchivo = tamanoArchivo;
        this.formato = formato;
    }

    // Getters y Setters
    public double getTamanoArchivo() {
        return tamanoArchivo;
    }

    public void setTamanoArchivo(double tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
