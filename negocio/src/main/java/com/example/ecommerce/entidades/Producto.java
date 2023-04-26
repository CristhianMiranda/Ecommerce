package com.example.ecommerce.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(nullable = false)
    @ToString.Include
    private String nombre;

    private String referencia;

    private String urlFoto;

    @Column(nullable = false)
    @ToString.Include
    private int cantidad;

    private String categoria;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Administrador administrador;

    @OneToMany(mappedBy = "carrito")
    private List<DetalleCarrito> detalleCarritos;
//nombre,cantidad,categoria,referencia,urlFoto


    public Producto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.urlFoto = urlFoto;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
}
