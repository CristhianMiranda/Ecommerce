package com.example.ecommerce;

import com.example.ecommerce.servicios.AdministradorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ServiciosApplicationTests {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    void contextLoads() {
        System.out.println("Prueba");
    }





}
