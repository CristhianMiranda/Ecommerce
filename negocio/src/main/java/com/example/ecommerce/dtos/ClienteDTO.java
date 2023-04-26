package com.example.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private int cedula;
    private String nombre;
    private List<CarritoDTO> carritos;

}
