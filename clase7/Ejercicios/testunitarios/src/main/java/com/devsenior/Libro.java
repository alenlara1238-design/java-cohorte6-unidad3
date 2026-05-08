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

    @Override
    public boolean equals (Object o){
        
    }

}
