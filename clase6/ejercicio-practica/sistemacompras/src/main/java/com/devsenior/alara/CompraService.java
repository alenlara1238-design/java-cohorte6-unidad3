package com.devsenior.alara;

public class CompraService {

    public ResultadoCompra comprar(Carrito carrito){
        if(carrito.estaVacio()){
            throw new RuntimeException("El carrito está vacio");
        }
        carrito.vaciar();
        return new CompraExitosa();
    }

    public String generarMensaje(){
        return "Compra realizada con éxito";
    }
}
