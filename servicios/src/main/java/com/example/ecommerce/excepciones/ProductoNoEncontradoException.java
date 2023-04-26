package com.example.ecommerce.excepciones;

public class ProductoNoEncontradoException extends  RuntimeException{
    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}
