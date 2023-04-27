package com.example.ecommerce;


import com.example.ecommerce.dtos.ClienteDto;
import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.repositorios.ClienteRepositorio;
import com.example.ecommerce.repositorios.DetalleCarritoRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Transactional
public class ClienteServicioTest {
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private DetalleCarritoRepositorio detalleCarritoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void testObtenerProductos()
    {
       // productoRepositorio.deleteAll();
        Producto producto = new Producto("PS4","Producto 1", "Categoria 1", 10, "http://urlfoto1.com");
        productoRepositorio.save(producto);

        for (ProductoDto obtenerProducto : clienteServicio.obtenerProductos()) {
            System.out.println(obtenerProducto);
        }
        Assertions.assertFalse( clienteServicio.obtenerProductos().isEmpty());
    }

    @Test
    public void testAgregarProductoCarrito()
    {
        //detalleCarritoRepositorio.deleteAll();
        if(productoRepositorio.buscarProductoId(1).equals(null))
        {
            Producto producto = new Producto("PS5","Producto 1", "Categoria 1", 10, "http://urlfoto1.com");
            ProductoDto productoDto = new ProductoDto();
            productoDto.setCantidad(producto.getCantidad());
            productoDto.setNombre(producto.getNombre());
            productoDto.setCategoria(producto.getCategoria());
            productoDto.setId(producto.getId());
            productoDto.setUrlFoto(producto.getUrlFoto());
        }else{
            Producto producto = productoRepositorio.buscarProductoId(1);
            ProductoDto productoDto = new ProductoDto();
            productoDto.setCantidad(producto.getCantidad());
            productoDto.setNombre(producto.getNombre());
            productoDto.setCategoria(producto.getCategoria());
            productoDto.setId(producto.getId());
            productoDto.setUrlFoto(producto.getUrlFoto());
            Cliente cliente = new Cliente();
            cliente.setCedula(123);
            cliente.setNombre("juan");
            cliente = clienteRepositorio.save(cliente);

            ClienteDto clienteDto = new ClienteDto(cliente.getCedula(),cliente.getNombre());
            clienteServicio.agregarProductoCarrito(productoDto,3,clienteDto);

            Assertions.assertFalse(detalleCarritoRepositorio.findAll().isEmpty());
        }



    }

    @Test
    public void obtenerProductosAgregados(){
        Assertions.assertFalse(clienteServicio.obtenerProductosAgregados(123).isEmpty());
    }
}
