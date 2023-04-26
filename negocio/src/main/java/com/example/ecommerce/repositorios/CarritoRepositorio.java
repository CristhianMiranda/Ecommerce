package com.example.ecommerce.repositorios;

import com.example.ecommerce.entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarritoRepositorio extends JpaRepository<Carrito,String> {

    @Query("SELECT c FROM Carrito c WHERE c.cliente.cedula = :cedula")
    Optional<Carrito> buscarClienteCarrito(int cedula);


}
