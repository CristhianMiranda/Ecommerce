package com.example.ecommerce.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @ToString.Include
    private String nombre;

    @ToString.Include
    private String referencia;

    @ToString.Include
    private String urlFoto;

    @Column(nullable = false)
    @ToString.Include
    private int cantidad;

    @ToString.Include
    private String categoria;

    @ManyToOne
    private Administrador administrador;

    @OneToMany(mappedBy = "carrito")
    private List<DetalleCarrito> detalleCarritos;


    public Producto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.urlFoto = urlFoto;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
}
