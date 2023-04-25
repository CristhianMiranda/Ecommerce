package com.example.negocio.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
