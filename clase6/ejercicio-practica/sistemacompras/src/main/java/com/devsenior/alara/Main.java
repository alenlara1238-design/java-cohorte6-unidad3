package com.devsenior.alara;

import javax.naming.spi.DirStateFactory.Result;

public class Main {
    public static void main(String[] args) {
    
        System.out.println("===INICIO DO SISTEMA DE COMPRAS===");

        //1. crear usuario
        Usuario usuario1 = new Usuario("maria@gmail.com", "1234");

        //2. Intentar login
        System.out.println("Intentando login con contraseña correcta...");
        boolean loginExitoso = usuario1.login("1234");

        if(loginExitoso){
            System.out.println("Login exitoso. Usuario autenticado.");
        } else {
            System.out.println("Login fallido. Usuario no autenticado.");
        }

        //3. Crear repositorio y productos
        ProductoRepository repositorio = new ProductoRepository();
        Producto producto1 = new Producto("1", "Laptop", 1500.00);
        Producto producto2 = new Producto("2", "Smartphone", 800.00);
        repositorio.guardar(producto1);
        repositorio.guardar(producto2);


        //4. Buscar producto por ID
        System.out.println("Buscando producto con ID '1'...");
        Producto encontrado = repositorio.buscarPorId("1");
       
        System.out.println("Producto encontrado: " +
            (encontrado != null ? encontrado.getNombre() : "No encontrado")
        );

        //5. Buscar producto iniexistente
        System.out.println("Buscando producto con ID '3'...");
        Producto noEncontrado = repositorio.buscarPorId("3");
        System.out.println("Producto encontrado: " +
            (noEncontrado != null ? noEncontrado.getNombre() : "No encontrado")
        );


        //6. Carrito de compras
        System.out.println("Agregando productos al carrito...");
        Carrito carrito = new Carrito();
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);

        System.out.println("Productos en el carrito:");
        for (Producto p : carrito.getProductos()) {
            System.out.println("- " + p.getNombre() + "Precio: $" + p.getPrecio());
        }

        //comprar
        System.out.println("Realizando compra...");
        CompraService compraService = new CompraService();
       
        try {
             ResultadoCompra resultado = compraService.comprar(carrito);

            if(resultado instanceof CompraExitosa){
                System.out.println(compraService.generarMensaje());
            }
        } catch (Exception e) {
            
             System.out.println("Error en la compra: " + e.getMessage());
        }
       
    }
}