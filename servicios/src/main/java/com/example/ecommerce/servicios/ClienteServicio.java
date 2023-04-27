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

    List<ProductoDto>obtenerProductos() ;


    DetalleCarritoDto agregarProductoCarrito(ProductoDto productoDto, int cantidadProducto, ClienteDto clienteDto)  throws ProductoNoDisponibleException;


    List<String> obtenerProductosAgregados(int cedula) throws CarritoNoEncontradoException;

    Cliente buscarClientePorCedula(int cedula);

}
