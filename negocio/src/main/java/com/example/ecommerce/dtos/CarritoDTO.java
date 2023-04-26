package com.example.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO implements Serializable {
    private int id;
    private Date fechaCreacionDate;
    private ClienteDTO cliente;
    private List<DetalleCarritoDTO> detalleCarritos;

}
