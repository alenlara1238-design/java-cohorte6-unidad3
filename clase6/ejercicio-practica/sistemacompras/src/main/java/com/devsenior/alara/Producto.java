package com.devsenior.alara;

public class Producto {
    private String id;
    private String nombre;
    private double precio;


    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true; // Verifica si son el mismo objeto  en memoria
        if(!(o instanceof Producto)) return false; // Verifica si el objeto es del mismo tipo
        Producto producto = (Producto) o; //si 'o' es un producto, entonces, averiguemos si son iguales por su id
        return this.id.equals(producto.id);
    }
}
