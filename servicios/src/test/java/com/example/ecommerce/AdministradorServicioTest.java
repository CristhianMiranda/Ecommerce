package com.example.ecommerce;

import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.repositorios.AdministradorRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdministradorServicioTest {
    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private AdministradorRepositorio administradorRepositorio;


    @Test
    public void testCrearProducto() {
        // Arrange
        String nombre = "Jabon";
        String referencia = "REF123";
        String urlFoto = "https://i.postimg.cc/C5ypVmRj/imagen-2023-04-26-032641281.png";
        int cantidad = 10;
        String categoria = "Higiene";


        Producto producto = administradorServicio.crearProducto(nombre, referencia, urlFoto, cantidad, categoria);


        assertNotNull(producto);
        assertNotNull(producto.getId());
        assertEquals(nombre, producto.getNombre());
        assertEquals(referencia, producto.getReferencia());
        assertEquals(urlFoto, producto.getUrlFoto());
        assertEquals(cantidad, producto.getCantidad());
        assertEquals(categoria, producto.getCategoria());


    }

    @Test
    public void testListarProductos() throws ProductoException {
        productoRepositorio.deleteAll();

        administradorServicio.crearProducto("PS5", "REF123", "https://i.postimg.cc/kGjNbhWS/imagen-2023-04-26-032926332.png", 5, "Tecnologia");

        // Obtenemos la lista de productos
        List<Producto> listaProductos = administradorServicio.listarProductos();

        // Verificamos que la lista no esté vacía
        Assertions.assertFalse(listaProductos.isEmpty());


    }

    @Test
    void testActualizarProducto() {
        productoRepositorio.deleteAll();
        // Crear un producto de prueba
        Producto producto = new Producto();
        producto.setNombre("Producto de prueba");
        producto.setReferencia("REF-1234");
        producto.setUrlFoto("https://example.com/foto.jpg");
        producto.setCantidad(10);
        producto.setCategoria("Electrónica");
        Producto productoGuardado = administradorServicio.crearProducto(producto.getNombre(),producto.getReferencia(),producto.getUrlFoto(),producto.getCantidad(),producto.getCategoria());

        // Actualizar el producto
        productoGuardado.setCantidad(5);
        Producto productoActualizado = administradorServicio.actualizarProducto(productoGuardado);

        // Verificar que el producto se actualizó correctamente
        Assertions.assertEquals(5, productoActualizado.getCantidad());
    }

    @Test
    void testEliminarProducto() {
        productoRepositorio.deleteAll();
        // Crear un producto de prueba
        Producto producto = new Producto();
        producto.setNombre("Producto de prueba");
        producto.setReferencia("REF-1234");
        producto.setUrlFoto("https://example.com/foto.jpg");
        producto.setCantidad(10);
        producto.setCategoria("Electrónica");
        Producto productoGuardado = administradorServicio.crearProducto(producto.getNombre(),producto.getReferencia(),producto.getUrlFoto(),producto.getCantidad(),producto.getCategoria());

        // Eliminar el producto
        administradorServicio.eliminarProducto(productoGuardado);

        // Verificar que el producto fue eliminado
        Assertions.assertNull(administradorRepositorio.findById(String.valueOf(productoGuardado.getId())));
    }
}



