package com.example.ecommerce.servicios;

import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;

import java.util.List;

public interface AdministradorServicio {

    /**
     * Crea un nuevo producto.
     * @param nombre el nombre del producto.
     * @param referencia la referencia del producto.
     * @param urlFoto la URL de la foto del producto.
     * @param cantidad la cantidad disponible del producto.
     * @param categoria la categoría del producto.
     * @return un objeto Producto que representa el producto creado.
     * @throws ProductoException si ocurre un error al crear el producto.
     */
    Producto crearProducto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) throws ProductoException;

    /**
     * Obtiene una lista de productos.
     * @return una lista de objetos ProductoDto que representan los productos.
     * @throws ProductoException si ocurre un error al obtener los productos.
     */
    List<ProductoDto> obtenerProductos() throws ProductoException;

    /**
     * Actualiza un producto existente.
     * @param producto el producto a actualizar.
     * @return un objeto Producto que representa el producto actualizado.
     * @throws ProductoException si ocurre un error al actualizar el producto.
     */
    Producto actualizarProducto(Producto producto) throws ProductoException;

    /**
     * Elimina un producto existente.
     * @param producto el producto a eliminar.
     * @throws ProductoException si ocurre un error al eliminar el producto.
     */
    void eliminarProducto(Producto producto) throws ProductoException;
}
