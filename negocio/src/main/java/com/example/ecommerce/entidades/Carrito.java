package com.example.ecommerce.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDateTime fechaCreacionDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "carrito")
    private List<DetalleCarrito> detalleCarritos;
}
