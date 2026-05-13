package com.devsenior;

public class Libro {

    private String titulo;
    private boolean disponible; //representa un estado del libro, si esta disponible o no

    public Libro(String titulo) {

        if(titulo.isBlank() || titulo.isEmpty()){
            throw new IllegalArgumentException("El título del libro no puede estar vacío.");
        }
        this.titulo = titulo;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        if (disponible) {
            disponible = false; //ahora ya no está disponible
        } else {
            throw new IllegalStateException("El libro no está disponible para prestar.");
        }
    }

    public void devolver(){
        if(!disponible){
            disponible = true; //cuando se devuelve el libro, vuelve a estar disponible
        } else {
            throw new IllegalStateException("El libro ya está disponible, no se puede devolver.");
        }
    
    }

    
    @Override //estamos eclipsando el método equals heredado.
    public boolean equals (Object o){
        //1. Identidad (this == o), verificar: se refiere a si los dos objetos tienen la misma referencia en memoria.
        if(this == o) return true;

        //2. Nulidad ó comparación de clases: descartar igualdad.
        if(o == null  ||  this.getClass() != o.getClass()){
            return false;
        }

        //3. Criterio propio o que nosotros mismos establecemos: Si los dos libros tienen el mismo título return true
        Libro libro = (Libro) o; //casting, casteo, conversión explícita, parseo.
        return this.titulo.equals(libro.getTitulo());
    }
    

   

}
