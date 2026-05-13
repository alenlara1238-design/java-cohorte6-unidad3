package com.devsenior;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros; //etse parémtro va a permitir realizar operaciones de colección sobre los libros: buscar libros, añadir un libro, eliminar libros,etc.. CRUD.

    public Biblioteca(){
        libros = new ArrayList<>(); //este constructor garantiza que la biblioteca nacerá sin libros.
    }

    public void agregarLibro(Libro libro){
        //regla: no se admiten null o libros sin titulos.
        if(libro == null || libro.getTitulo().isBlank()){
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        //regla: no se admiten libros iguales.
        if(libros.contains(libro)){
            throw new IllegalArgumentException("El libro ya existe");
        }

        libros.add(libro); // esta libea garanntiza que si se agrega exitosamente el libro, la cantidad de libros debe aumentar en 1.
    }

    public int cantidadLibros(){
        return libros.size(); //size() es el equivalente a Length en arreglos.
    }

    //esta clase debería permitir busqueda.
    public Libro buscarLibro(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }

        Libro libroActual = null;
        for(int i= 0; i < libros.size(); i++){
            libroActual = libros.get(i);

            if(libroActual.getTitulo().equals(titulo)){
                return libroActual;
            }
        }
        throw new IllegalArgumentException("Libro no encontrado");
    }
}
