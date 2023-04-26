package com.example.ecommerce;

import com.example.ecommerce.dtos.CarritoDTO;
import com.example.ecommerce.dtos.ClienteDTO;
import com.example.ecommerce.entidades.Administrador;
import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.repositorios.AdministradorRepositorio;
import com.example.ecommerce.repositorios.CarritoRepositorio;
import com.example.ecommerce.repositorios.ClienteRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.AdministradorServicio;
import com.example.ecommerce.servicios.ClienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClienteServicioTest {
    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    @Autowired
    private CarritoRepositorio carritoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void visualizarProductos()
    {
        productoRepositorio.deleteAll();

        Administrador administrador = new Administrador();
        administrador.setNombre("Gustavo");

        Producto producto = new Producto("Pantene","1ED20","https://i.postimg.cc/hjT6ZMZ6/imagen-2023-04-26-010443940.png",10,"Higiene personal");
        Producto producto1 = new Producto("HeadShoulder","3ED41","https://i.postimg.cc/mDFSwQGt/imagen-2023-04-26-012521974.png",5,"Higiene personal");



        productoRepositorio.saveAll(Arrays.asList(producto, producto1));

        ArrayList<Producto> productos = clienteServicio.visualizarProductos();


        //Verifico si observo los mismos numeros de productos
        Assertions.assertEquals(productos.size(),productoRepositorio.findAll().size());


    }

    @Test
    public void agregarCarrito(){

        carritoRepositorio.deleteAll();
        productoRepositorio.deleteAll();

        Cliente cliente = new Cliente();
        cliente.setCedula(1010125168);
        cliente.setNombre("Cristhian");


        /*
        Carrito carrito = new Carrito();
        carrito.setCliente(clienteRepositorio.save(cliente));
        carrito.setFechaCreacionDate(LocalDateTime.now());
        carritoRepositorio.save(carrito);
        */
        Producto producto = new Producto("Pantene","1ED20","https://i.postimg.cc/hjT6ZMZ6/imagen-2023-04-26-010443940.png",10,"Higiene personal");
        //producto.setId(30);
        //productoRepositorio.save(producto);
        productoRepositorio.save(producto);

        Carrito carrito1 = clienteServicio.agregarAlCarrito(producto,1,clienteRepositorio.save(cliente));


        Assertions.assertTrue(carritoRepositorio.existsById(String.valueOf(carrito1.getId())));


    }

    @Test
    public void eliminarCarrito()
    {
        Cliente cliente = new Cliente();
        cliente.setCedula(1010124459);
        cliente.setNombre("Pablo");



        Carrito carrito = new Carrito();
        carrito.setCliente(clienteRepositorio.save(cliente));
        carrito.setFechaCreacionDate(LocalDateTime.now());
        carritoRepositorio.save(carrito);


        clienteServicio.vaciarCarrito(carrito,cliente);
        Assertions.assertTrue(carritoRepositorio.findAll().isEmpty());
    }

}
