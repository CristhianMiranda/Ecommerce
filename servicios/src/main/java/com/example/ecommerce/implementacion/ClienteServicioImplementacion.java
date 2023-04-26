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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
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
    public ArrayList<Producto> visualizarProductos() throws ProductoException {
        ArrayList<Producto> productos = (ArrayList<Producto>) productoRepositorio.findAll();
        if (productos.isEmpty()) {
            throw new ProductoException("No se encontraron productos");
        }
        return productos;
    }
    @Override
    public Carrito agregarAlCarrito(Producto producto, int cantidad, Cliente cliente) throws ProductoNoEncontradoException{


        //Producto producto1 = productoOptional.get();

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

        return carrito;
    }




    @Override
    public Boolean vaciarCarrito(Carrito carrito,Cliente cliente) throws CarritoNoEncontradoException {
        //Optional<Carrito> carritoOpt = carritoRepositorio.buscarClienteCarrito(cliente.getCedula());
        if (carrito.equals(null)) {
            throw new CarritoNoEncontradoException("No se encontró el carrito del cliente");
        }
        /*DetalleCarrito detalleCarrito = detalleCarritoRepositorio.buscarCarrito(carritoOpt.get().getId());
        for (detalleCarrito.getProducto() item : carrito.getItems()) {
            Producto producto = item.getProducto();
            producto.setCantidad(producto.getCantidad() + item.getCantidad());
        }*/
        carritoRepositorio.deleteAll();
        return true;
    }


}
