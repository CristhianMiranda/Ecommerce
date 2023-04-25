package com.example.negocio.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO implements Serializable {
    private int id;
    private String nombre;
    private List<ProductoDTO> productos;
}
