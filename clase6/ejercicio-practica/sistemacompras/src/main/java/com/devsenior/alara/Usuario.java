package com.devsenior.alara;

public class Usuario {
    private String email;
    private String password;
    private boolean autenticado;
    private boolean bloqueado;


    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
        this.autenticado = false;
        this.bloqueado = false;
    }

    public boolean login(String password){
        if(this.bloqueado) return false;

        if(this.password.equals(password)){
            this.autenticado = true;
            return true;
        } 
        return false;
    }

    public boolean estaAutenticado() {
        return autenticado;
    }

    public boolean estaBloqueado() {
        return bloqueado;
    }

}
