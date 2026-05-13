package com.devsenior;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LibroTest {

    @Test
    void libroNuevoDebeEstarDisponible() {
        Libro libro = new Libro("El Quijote");
       assertTrue(libro.isDisponible());
    }

    @Test
    void prestarLibroDisponibleDebeCambiarEstado() {
        Libro libro = new Libro("El Quijote");
        libro.prestar();
        assertFalse(libro.isDisponible());
    }

    //aquí escribir caso de devolver luego de prestar
    @Test
    void noDebePermitirPrestarDosVeces(){
        Libro libro = new Libro("El Quijote");
        libro.prestar();
  
        assertThrows(IllegalStateException.class,
                    () -> libro.prestar()
            );
        
        //aquí se espera que se lance una excepción al intentar prestar nuevamente
    }

    @Test
    void noDebePermitirTituloVacio(){
        assertThrows(IllegalArgumentException.class,
                    () -> new Libro("")
            );
    }

}
