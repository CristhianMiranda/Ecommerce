package com.example.ecommerce.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto implements Serializable {

    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private String urlFoto;
    /*
    private int id;
    private String nombre;
    private String referencia;
    private String urlFoto;
    private int cantidad;
    private String categoria;
*/

}
