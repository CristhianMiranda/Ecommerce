package com.example.ecommerce.controllers;


import com.example.ecommerce.entidades.Carrito;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.DetalleCarrito;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.CarritoNoEncontradoException;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.excepciones.ProductoNoEncontradoException;
import com.example.ecommerce.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usr")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ClienteApi {

    @Autowired
    ClienteServicio clienteServicio;


    @GetMapping("/productos")
    @ResponseBody
    public ArrayList<Producto> visualizarProductos() throws ProductoException {

        return clienteServicio.visualizarProductos();
    }

    @PostMapping("/agregar/{cantidad}")
    //@ResponseBody
    public ResponseEntity<Carrito> agregarAlCarrito(@RequestBody Producto producto
                                                    ,@PathVariable("cantidad") int cantidad
                                                    ,@RequestBody Cliente cliente) {
        Carrito carrito = clienteServicio.agregarAlCarrito(producto, cantidad, cliente);
        return ResponseEntity.ok(carrito);

    }


    @DeleteMapping("/carrito/vaciar")
    public void vaciarCarritos(@RequestBody Carrito carrito, @RequestBody Cliente cliente) {
        clienteServicio.vaciarCarrito(carrito, cliente);

    }

}
