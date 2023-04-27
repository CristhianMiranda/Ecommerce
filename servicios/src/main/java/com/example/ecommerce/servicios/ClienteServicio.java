package com.example.ecommerce.servicios;


import com.example.ecommerce.dtos.ClienteDto;
import com.example.ecommerce.dtos.DetalleCarritoDto;
import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.DetalleCarrito;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.CarritoNoEncontradoException;
import com.example.ecommerce.excepciones.ProductoNoDisponibleException;
import com.example.ecommerce.excepciones.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public interface ClienteServicio {

    /**
     * Obtiene una lista de productos.
     * @return una lista de objetos ProductoDto que representan los productos.
     */
    List<ProductoDto> obtenerProductos();

    /**
     * Agrega un producto al carrito.
     * @param productoDto el producto a agregar al carrito.
     * @param cantidadProducto la cantidad del producto a agregar.
     * @param clienteDto el cliente que agrega el producto a su carrito.
     * @return un objeto DetalleCarritoDto que representa el carrito actualizado.
     * @throws ProductoNoDisponibleException si el producto no está disponible.
     */
    DetalleCarritoDto agregarProductoCarrito(ProductoDto productoDto, int cantidadProducto, ClienteDto clienteDto) throws ProductoNoDisponibleException;

    /**
     * Obtiene los productos agregados al carrito de un cliente.
     * @param cedula la cédula del cliente cuyo carrito se quiere consultar.
     * @return una lista de cadenas que representan los productos agregados al carrito del cliente.
     * @throws CarritoNoEncontradoException si no se encuentra el carrito del cliente.
     */
    List<String> obtenerProductosAgregados(int cedula) throws CarritoNoEncontradoException;

    /**
     * Busca un cliente por su cédula.
     * @param cedula la cédula del cliente a buscar.
     * @return un objeto Cliente que representa al cliente encontrado, o null si no se encuentra ningún cliente con esa cédula.
     */
    Cliente buscarClientePorCedula(int cedula);

}
