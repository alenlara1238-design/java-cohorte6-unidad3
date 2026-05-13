package com.devsenior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assumptions.abort;

import org.junit.jupiter.api.Test;

public class BibliotecaTest {

    //regla 1: al nacer una biblio debe nacer sin libros
    @Test
    void bibliotecaNuevaDebeEstarVacia(){
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(0, biblioteca.cantidadLibros());
    }
    //reglas de agregar libros
    //cuando agregue libro exitosamente, la cantidad debe aumentar.
    @Test
    void cantidadLibrosDebeAumentarAlAgregar(){
        Biblioteca biblioteca = new Biblioteca();
        Libro l1 = new Libro("Java es el mejor lenguaje");
        biblioteca.agregarLibro(l1);
        assertEquals(1, biblioteca.cantidadLibros());
    }

    @Test
    void agregarVariosLibrosDebeAumentarCantidad(){
        Biblioteca biblioteca = new Biblioteca();
        Libro l1 = new Libro("Java");
          Libro l2 = new Libro("Spring");
            Libro l3 = new Libro("DDD");
              Libro l4 = new Libro("Python");
        
        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        biblioteca.agregarLibro(l4);

        assertEquals(4, biblioteca.cantidadLibros());
    }

    @Test
    void noDebePermitirLibrosNullos(){
        Biblioteca biblioteca = new Biblioteca();
        Libro l1 = null;
        assertThrows(IllegalArgumentException.class, () -> {
                biblioteca.agregarLibro(l1);
        });
    }

    @Test
    void noDebePermitirLibrosDuplicados(){
        Biblioteca biblioteca = new Biblioteca();
         Libro libro1 = new Libro("Java");
         Libro libro2 = new Libro("Java");

         biblioteca.agregarLibro(libro1);
        
         assertThrows(IllegalArgumentException.class, () ->{
            biblioteca.agregarLibro(libro2);
         });
    }

    @Test
    void noDebeAceptarTitulosEnBlanco(){
        Biblioteca biblioteca = new Biblioteca();
        
        assertThrows(IllegalArgumentException.class, () ->{
             Libro libro1 = new Libro("");
             biblioteca.agregarLibro(libro1);
        });
    }

    @Test
    void deberiaEncontrarLibroExistente(){
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("Java");

        biblioteca.agregarLibro(libro);

       Libro resultado = biblioteca.buscarLibro("Java");

       assertEquals(libro, resultado);

    }
}
