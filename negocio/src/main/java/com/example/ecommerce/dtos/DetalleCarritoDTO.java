package com.example.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCarritoDTO implements Serializable {
    private int id;
    private ProductoDTO producto;
    private CarritoDTO carrito;
    private int cantidad;
}
