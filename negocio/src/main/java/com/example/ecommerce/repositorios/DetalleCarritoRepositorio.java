package com.example.ecommerce.repositorios;

import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.DetalleCarrito;
import com.example.ecommerce.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DetalleCarritoRepositorio extends JpaRepository<DetalleCarrito,String> {


    @Query("select d from DetalleCarrito  d where d.carrito.id = :id")
    DetalleCarrito buscarCarrito (int id);

    @Query("select p.nombre from Producto p JOIN p.detalleCarritos d JOIN d.carrito car JOIN car.cliente c WHERE c.cedula= :cedula")
    List<String> obtenerProductosAgregadosPorCliente(int cedula);
}
