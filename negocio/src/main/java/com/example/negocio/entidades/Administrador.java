package com.example.negocio.entidades;

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
public class Administrador implements Serializable {
    @ToString.Include
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private int id;

    @Column(length = 80,nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "administrador")
    private List<Producto> productos;

}
