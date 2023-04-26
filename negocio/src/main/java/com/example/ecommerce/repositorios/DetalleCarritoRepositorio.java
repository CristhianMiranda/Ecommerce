package com.example.ecommerce.repositorios;

import com.example.ecommerce.entidades.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCarritoRepositorio extends JpaRepository<DetalleCarrito,String> {


    @Query("select d from DetalleCarrito  d where d.carrito.id = :id")
    DetalleCarrito buscarCarrito (int id);
}
