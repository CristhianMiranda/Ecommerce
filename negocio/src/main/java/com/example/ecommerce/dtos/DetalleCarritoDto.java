package com.example.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCarritoDto implements Serializable {

    private ProductoDto producto;
    private CarritoDto carrito;
    private int cantidad;
}
