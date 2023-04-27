package com.example.ecommerce.implementacion;
import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.repositorios.AdministradorRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.AdministradorServicio;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImplementacion implements AdministradorServicio {
    //private final AdministradorRepositorio administradorRepositorio;
    private final AdministradorRepositorio administradorRepositorio;
    private final ProductoRepositorio productoRepositorio;


    public AdministradorServicioImplementacion(AdministradorRepositorio administradorRepositorio, ProductoRepositorio productoRepositorio) {
        this.administradorRepositorio = administradorRepositorio;
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public Producto crearProducto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) {

        if (nombre == null || nombre.isEmpty()) {
            throw new ProductoException("El nombre del producto no puede ser nulo o vacío");
        }

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setReferencia(referencia);
        producto.setUrlFoto(urlFoto);
        producto.setCantidad(cantidad);
        producto.setCategoria(categoria);
        return productoRepositorio.save(producto);
    }

    @Override
    public List<ProductoDto>  obtenerProductos() {
        List<Producto> productos = productoRepositorio.findAll();

        List<ProductoDto> productosDTO = new ArrayList<>();
        for (Producto producto : productos) {
            productosDTO.add(new ProductoDto( producto.getId(),producto.getNombre(), producto.getCategoria(), producto.getCantidad(), producto.getUrlFoto()));
        }

        return productosDTO;

    }

    @Override
    public Producto actualizarProducto(Producto producto) throws ProductoException{


        return productoRepositorio.save(producto);
    }





    @Override
    public void eliminarProducto(Producto producto) throws ProductoException {
        productoRepositorio.delete(producto);
    }


}

