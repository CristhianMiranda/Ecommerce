package com.example.ecommerce.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @ToString.Include
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private int cedula;

    @Column(length = 80,nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "cliente")
    private List<Carrito> carritos;


}
