package com.example.ecommerce.repositorios;

import com.example.ecommerce.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,String> {
    @Query("select p from Producto p where p.id =:id")
    Producto buscarProductoId(int id);
}
