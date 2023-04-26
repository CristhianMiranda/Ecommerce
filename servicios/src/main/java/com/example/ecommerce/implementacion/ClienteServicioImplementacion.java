package com.example.ecommerce.implementacion;

import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.DetalleCarrito;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.CarritoNoEncontradoException;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.excepciones.ProductoNoEncontradoException;
import com.example.ecommerce.repositorios.CarritoRepositorio;
import com.example.ecommerce.repositorios.DetalleCarritoRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.ClienteServicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ClienteServicioImplementacion implements ClienteServicio {
    private final ProductoRepositorio productoRepositorio;

    private final CarritoRepositorio carritoRepositorio;

    private final DetalleCarritoRepositorio detalleCarritoRepositorio;


    public ClienteServicioImplementacion(ProductoRepositorio productoRepositorio, CarritoRepositorio carritoRepositorio, DetalleCarritoRepositorio detalleCarritoRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.carritoRepositorio = carritoRepositorio;
        this.detalleCarritoRepositorio = detalleCarritoRepositorio;
    }

    @Override
    public List<Producto> visualizarProductos() throws ProductoException {
        List<Producto> productos = productoRepositorio.findAll();
        if (productos.isEmpty()) {
            throw new ProductoException("No se encontraron productos");
        }
        return productos;
    }
    @Override
    public void agregarAlCarrito(String idProducto, int cantidad, Cliente cliente) throws ProductoNoEncontradoException{
        Optional<Producto> productoOptional = productoRepositorio.findById(idProducto);
        if (!productoOptional.isPresent()) {
            throw new ProductoNoEncontradoException("No se encontró el producto con ID " + idProducto);
        }

        Producto producto = productoOptional.get();

        if (producto.getCantidad() < cantidad) {
            throw new ProductoException("No hay suficiente stock para la cantidad de productos que necesitas");
        }

        Carrito carrito = new Carrito();
        carrito.setCliente(cliente);
        carrito.setFechaCreacionDate(LocalDateTime.now());
        carritoRepositorio.save(carrito);

        DetalleCarrito detalleCarrito = new DetalleCarrito();
        detalleCarrito.setProducto(producto);
        detalleCarrito.setCarrito(carrito);
        detalleCarrito.setCantidad(cantidad);
        detalleCarritoRepositorio.save(detalleCarrito);

        producto.setCantidad(producto.getCantidad() - cantidad);
        productoRepositorio.save(producto);
    }




    @Override
    public void vaciarCarrito(Cliente cliente) throws CarritoNoEncontradoException {
        Optional<Carrito> carritoOpt = carritoRepositorio.buscarClienteCarrito(cliente.getCedula());
        if (carritoOpt.isEmpty()) {
            throw new CarritoNoEncontradoException("No se encontró el carrito del cliente");
        }
        /*DetalleCarrito detalleCarrito = detalleCarritoRepositorio.buscarCarrito(carritoOpt.get().getId());
        for (detalleCarrito.getProducto() item : carrito.getItems()) {
            Producto producto = item.getProducto();
            producto.setCantidad(producto.getCantidad() + item.getCantidad());
        }*/
        carritoRepositorio.deleteAll();
    }


}
