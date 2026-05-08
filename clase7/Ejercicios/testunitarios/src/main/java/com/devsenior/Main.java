package com.devsenior;

public class Main {
    public static void main(String[] args) {
       Libro libro = new Libro("El Quijote");

       Libro libro2 = new Libro("");
       
      
       //libro4.prestar();
       System.out.println(libro.isDisponible());

       libro.prestar();
         System.out.println(libro.isDisponible());

        libro.devolver();
        libro.devolver();
        libro.devolver();
         System.out.println(libro.isDisponible());
    }
}