package com.example.ecommerce.repositorios;

import com.example.ecommerce.entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepositorio extends JpaRepository<Carrito,String> {
}
