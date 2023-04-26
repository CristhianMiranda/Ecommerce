package com.example.ecommerce.excepciones;

public class CarritoNoEncontradoException extends RuntimeException{
    public CarritoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
