package com.devsenior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    
    @Test
    void testSumar() {
        //arrange: preparar el escenario de prueba
        Calculadora calc = new Calculadora();


        //act: ejecutar la acción a probar
        int resultado = calc.sumar(2, 3);


        //assert: verificar el resultado esperado
        assertEquals(5, resultado);
    }

    @Test
    void testDividir() {
        //arrange
        Calculadora calc = new Calculadora();

        //act
        //int resultado = calc.dividir(10, 2);

        //assert
        assertEquals(5, calc.dividir(10, 2));
    } 

    @Test
    void testDividirPorCero() {
        //arrange
        Calculadora calc = new Calculadora();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.dividir(10, 0); //aqui puedes arrojar la excepción pero no vas a interrunpir el flujo del test, el test va a continuar y va a verificar que la excepción se haya lanzado correctamente
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }

}
