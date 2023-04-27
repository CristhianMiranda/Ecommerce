package com.example.ecommerce.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCarrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Carrito carrito;

    @Column(nullable = false)
    @ToString.Include
    private int cantidad;


}
