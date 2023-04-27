package com.example.ecommerce.implementacion;

import com.example.ecommerce.dtos.CarritoDto;
import com.example.ecommerce.dtos.ClienteDto;
import com.example.ecommerce.dtos.DetalleCarritoDto;
import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.DetalleCarrito;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.CarritoNoEncontradoException;
import com.example.ecommerce.excepciones.ClienteNoEncontradoExcepcion;
import com.example.ecommerce.excepciones.ProductoNoDisponibleException;
import com.example.ecommerce.repositorios.CarritoRepositorio;
import com.example.ecommerce.repositorios.ClienteRepositorio;
import com.example.ecommerce.repositorios.DetalleCarritoRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.ClienteServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServicioImplementacion implements ClienteServicio {
    private final ProductoRepositorio productoRepositorio;

    private final CarritoRepositorio carritoRepositorio;

    private final DetalleCarritoRepositorio detalleCarritoRepositorio;
    private final ClienteRepositorio clienteRepositorio;


    public ClienteServicioImplementacion(ProductoRepositorio productoRepositorio, CarritoRepositorio carritoRepositorio, DetalleCarritoRepositorio detalleCarritoRepositorio,
                                         ClienteRepositorio clienteRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.carritoRepositorio = carritoRepositorio;
        this.detalleCarritoRepositorio = detalleCarritoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public List<ProductoDto> obtenerProductos() {
        List<Producto> productos = productoRepositorio.findAll();

        List<ProductoDto> productosDTO = new ArrayList<>();
        for (Producto producto : productos) {
            productosDTO.add(new ProductoDto( producto.getId(),producto.getNombre(), producto.getCategoria(), producto.getCantidad(), producto.getUrlFoto()));
        }

        return productosDTO;

    }
    @Override
    public DetalleCarritoDto agregarProductoCarrito(ProductoDto productoDto, int cantidadProducto, ClienteDto clienteDto) throws ProductoNoDisponibleException {

        Producto productoActualizado = productoRepositorio.buscarProductoId(productoDto.getId());

        if (productoActualizado.getCantidad() < cantidadProducto) {
            throw new RuntimeException("No hay suficiente stock disponible");
        }

        productoActualizado.setCantidad(productoActualizado.getCantidad() - cantidadProducto);

        Carrito carrito = new Carrito();

        Cliente cliente = buscarClientePorCedula(clienteDto.getCedula());

        carrito.setCliente(cliente);

        DetalleCarrito detalleCarrito = new DetalleCarrito();
        detalleCarrito.setCarrito(carritoRepositorio.save(carrito));
        detalleCarrito.setProducto(productoRepositorio.save(productoActualizado));
        detalleCarrito.setCantidad(cantidadProducto);
        detalleCarritoRepositorio.save(detalleCarrito);

        CarritoDto carritoDto = new CarritoDto(clienteDto);

        DetalleCarritoDto detalleCarritoDto = new DetalleCarritoDto();

        detalleCarritoDto.setProducto(productoDto);
        detalleCarritoDto.setCarrito(carritoDto);
        detalleCarritoDto.setCantidad(cantidadProducto);

        return detalleCarritoDto;

    }




    @Override
    public List<String> obtenerProductosAgregados(int cedula) {

        return detalleCarritoRepositorio.obtenerProductosAgregadosPorCliente(cedula);
    }

    @Override
    public Cliente buscarClientePorCedula(int cedula) throws ClienteNoEncontradoExcepcion {
        Cliente cliente = clienteRepositorio.buscarClientePorCedula(cedula);
        if (cliente == null) {
            throw new ClienteNoEncontradoExcepcion("El cliente con cédula " + cedula + " no existe.");
        }
        return cliente;
    }


}
