package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class AdministradorApi {

    @Autowired
    AdministradorServicio administradorServicio;


    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(
            @RequestBody Producto producto) {
        administradorServicio.crearProducto(producto.getNombre(), producto.getReferencia(), producto.getUrlFoto(), producto.getCantidad(), producto.getCategoria());
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }


    @GetMapping("/listarproductos")
    @ResponseBody
    public List<ProductoDto> listarProductos() throws ProductoException {

        return administradorServicio.obtenerProductos();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
        try {
            Producto productoActualizado = administradorServicio.actualizarProducto(producto);
            return ResponseEntity.ok().body(productoActualizado);
        } catch (ProductoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/eliminar")
    public void vaciarCarritos(@RequestBody Producto producto) {

        administradorServicio.eliminarProducto(producto);

    }

}



