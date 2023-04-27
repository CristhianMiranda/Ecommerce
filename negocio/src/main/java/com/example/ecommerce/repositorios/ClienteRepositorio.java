package com.example.ecommerce.repositorios;

import com.example.ecommerce.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,String> {

    @Query("select c from Cliente c where c.cedula =:cedula")
    Cliente buscarClientePorCedula(int cedula);
}
