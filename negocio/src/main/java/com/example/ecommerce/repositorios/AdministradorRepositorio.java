package com.example.ecommerce.repositorios;


import com.example.ecommerce.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador,String> {


}