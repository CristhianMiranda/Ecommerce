package com.example.ecommerce.servicios;


import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.CarritoNoEncontradoException;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.excepciones.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public interface ClienteServicio {
    /**
     * Permite visualizar todos los productos disponibles en la tienda.
     *
     * @return Lista de productos disponibles.
     * @throws ProductoException Si no se encuentran productos disponibles.
     */
    ArrayList<Producto> visualizarProductos() throws ProductoException;

    /**
     * Agrega un producto al carrito de compras de un cliente.
     *
     * @param idProducto El ID del producto a agregar al carrito.
     * @param cantidad La cantidad del producto a agregar al carrito.
     * @param cliente El cliente al cual agregar el producto al carrito.
     */
    Carrito agregarAlCarrito(Producto producto, int cantidad, Cliente cliente) throws ProductoNoEncontradoException;

    /**
     * Vacía el carrito de compras de un cliente.
     *
     * @param cliente El cliente cuyo carrito se desea vaciar.
     * @throws CarritoNoEncontradoException Si no se encuentra el carrito del cliente.
     */
    Boolean vaciarCarrito(Carrito carrito,Cliente cliente) throws CarritoNoEncontradoException;

}
