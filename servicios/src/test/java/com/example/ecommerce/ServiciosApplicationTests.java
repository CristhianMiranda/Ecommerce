package com.example.ecommerce;

import com.example.ecommerce.servicios.AdministradorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ServiciosApplicationTests {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    void contextLoads() {
    }

    @Test
    public void crearProducto() {
        administradorServicio.crearProducto("Locion","ACS-45244","https://i.postimg.cc/0Qbf9Pgw/imagen-2023-04-25-163916726.png",12,"Cuidado");
    }


}
