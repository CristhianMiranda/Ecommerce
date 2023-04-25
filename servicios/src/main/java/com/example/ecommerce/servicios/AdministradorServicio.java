package com.example.ecommerce.servicios;

import com.example.ecommerce.entidades.Producto;

public interface AdministradorServicio {

    Producto crearProducto(String nombre, String referencia, String urlFoto, int cantidad, String categoria);
}
