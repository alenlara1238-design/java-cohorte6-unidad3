package com.devsenior.alara;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LoginTest {
    
    @Test
    void deberiaAutenticarUsuariConCredencialesCorrectas(){
        //1. crear usuario
        Usuario usuario1 = new Usuario("maria@gmail.com", "1234");
        //2. Intentar login
        boolean loginExitoso = usuario1.login("1234");
        Assertions.assertTrue(loginExitoso);
         //Verificamos que el resultado interno cambió correctamente
        Assertions.assertTrue(usuario1.estaAutenticado());
    }
    
    @Test
    void noDeberiaAutenticarUsuarioConCredencialesIncorrectas(){
        //1. crear usuario
        Usuario usuario1 = new Usuario("maria@gmail.com", "1234");
        //2. Intentar login con contraseña incorrecta
        boolean loginExitoso = usuario1.login("incorrecta");
        Assertions.assertFalse(loginExitoso);
        //Verificamos que el resultado interno no cambió
        Assertions.assertFalse(usuario1.estaAutenticado());
    }
}
