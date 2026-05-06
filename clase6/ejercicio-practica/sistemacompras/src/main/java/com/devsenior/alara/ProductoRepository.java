package com.devsenior.alara;

import java.util.HashMap;
import java.util.Map;

public class ProductoRepository {
    private Map<String, Producto> productos = new HashMap<>();

    public void guardar(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public Producto buscarPorId(String id) {
        return productos.get(id); //puede retornar null si no encuentra el producto
    }
}
