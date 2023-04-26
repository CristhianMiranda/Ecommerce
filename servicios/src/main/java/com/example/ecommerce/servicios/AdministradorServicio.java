package com.example.ecommerce.servicios;

import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;

import java.util.List;

public interface AdministradorServicio {

    /**
     * Crea un nuevo producto con los datos proporcionados.
     *
     * @param nombre el nombre del producto
     * @param referencia la referencia del producto
     * @param urlFoto la URL de la foto del producto
     * @param cantidad la cantidad disponible del producto
     * @param categoria la categoría del producto
     * @return el producto creado
     * @throws ProductoException si no se puede crear el producto
     */
    Producto crearProducto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) throws ProductoException;

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return la lista de productos
     * @throws ProductoException si no se puede obtener la lista de productos
     */
    List<Producto> listarProductos() throws ProductoException;

    /**
     * Actualiza un producto existente con los datos proporcionados.
     *
     * @param producto el producto a actualizar
     * @return el producto actualizado
     * @throws ProductoException si no se puede actualizar el producto
     */
    Producto actualizarProducto(Producto producto) throws ProductoException;

    /**
     * Elimina un producto existente.
     *
     * @param producto el producto a eliminar
     * @throws ProductoException si no se puede eliminar el producto
     */
    void eliminarProducto(Producto producto) throws ProductoException;

}
