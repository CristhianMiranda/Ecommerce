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
    void contextLoads() {
        System.out.println("Prueba");
    }

}
