package com.devsenior;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;

    public Biblioteca(){
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro){
        if(libro == null){
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }
        libros.add(libro);
    }

    public int cantidadLibros(){
        return libros.size();
    }
}
