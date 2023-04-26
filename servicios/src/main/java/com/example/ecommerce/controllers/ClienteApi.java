package com.example.ecommerce.controllers;


import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.excepciones.ProductoException;
import com.example.ecommerce.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ClienteApi {

    @Autowired
    ClienteServicio clienteServicio;


    @GetMapping("/productos")
    @ResponseBody
    public ArrayList<Producto> visualizarProductos() throws ProductoException {

        return clienteServicio.visualizarProductos();
    }

}
