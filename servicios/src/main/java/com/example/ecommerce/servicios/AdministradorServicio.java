package com.example.ecommerce.servicios;

import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;

import java.util.List;

public interface AdministradorServicio {

    Producto crearProducto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) throws ProductoException;


    List<ProductoDto>  obtenerProductos() throws ProductoException;


    Producto actualizarProducto(Producto producto) throws ProductoException;


    void eliminarProducto(Producto producto) throws ProductoException;

}
