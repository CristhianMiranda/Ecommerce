package com.example.ecommerce;

import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.servicios.AdministradorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdministradorTest {
    @Autowired
    private AdministradorServicio administradorServicio;
    @Test
    public void crearProductoTest() {
        // Inicializamos los datos necesarios para el test
        String nombre = "Locion";
        String referencia = "ACS-45244";
        String urlFoto = "https://i.postimg.cc/0Qbf9Pgw/imagen-2023-04-25-163916726.png";
        int cantidad = 12;
        String categoria = "Cuidado";

        // Llamamos al método del servicio que queremos testear
        Producto productoCreado = administradorServicio.crearProducto(nombre, referencia, urlFoto, cantidad, categoria);

        // Verificamos que el resultado obtenido es el esperado
        assertNotNull(productoCreado);
        assertEquals(nombre, productoCreado.getNombre());
        assertEquals(referencia, productoCreado.getReferencia());
        assertEquals(urlFoto, productoCreado.getUrlFoto());
        assertEquals(cantidad, productoCreado.getCantidad());
        assertEquals(categoria, productoCreado.getCategoria());

        // Limpiamos los datos utilizados en el test
        //administradorRepositorio.delete(productoCreado);
    }

}
