package com.devsenior;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaquinaCafeTest {

    @Test
    void hacerCafeTest(){
        MaquinaCafe maquinaCafe = new MaquinaCafe(true, true);
        assertEquals("Café listo", maquinaCafe.hacerCafe());
    }

    @Test
    void hacerCafeSinAguaTest(){
        //Arrange
        MaquinaCafe maquinaCafe = new MaquinaCafe(false, true);
        assertEquals("Falta agua", maquinaCafe.hacerCafe());
    }

    @Test
    void hacerCafeSinCafeTest(){
        MaquinaCafe maquinaCafe = new MaquinaCafe(true, false);
        assertEquals("Falta café", maquinaCafe.hacerCafe());
    }

    @Test
    void hacerCafeSinAguaNiCafeTest(){
        MaquinaCafe maquinaCafe = new MaquinaCafe(false, false);
        assertEquals("Falta agua y café", maquinaCafe.hacerCafe());
    }
}
