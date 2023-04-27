package com.example.ecommerce.excepciones;

public class ClienteNoEncontradoExcepcion extends RuntimeException {
    public ClienteNoEncontradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
