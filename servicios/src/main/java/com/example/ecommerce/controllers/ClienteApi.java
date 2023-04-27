package com.example.ecommerce.controllers;


import com.example.ecommerce.dtos.ClienteDto;
import com.example.ecommerce.dtos.DetalleCarritoDto;
import com.example.ecommerce.dtos.ProductoDto;
import com.example.ecommerce.entidades.Cliente;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.repositorios.ClienteRepositorio;
import com.example.ecommerce.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ClienteApi {

    @Autowired
    ClienteServicio clienteServicio;

    ClienteRepositorio clienteRepositorio;
    @GetMapping("/productos")
    public List<ProductoDto> obtenerProductos()  {
        return clienteServicio.obtenerProductos();
    }

    @PostMapping("/carrito/{cantidadProductos}/{cedula}")
    public ResponseEntity<DetalleCarritoDto> agregarProductoAlCarrito(@RequestBody ProductoDto productoDto, @PathVariable int cantidadProductos, @PathVariable int cedula) {

        Cliente cliente = clienteServicio.buscarClientePorCedula(cedula);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setCedula(cliente.getCedula());
        clienteDto.setNombre(cliente.getNombre());

        return ResponseEntity.ok(clienteServicio.agregarProductoCarrito(productoDto,cantidadProductos,clienteDto));
    }

    @PostMapping("/carrito/productos/{cedula}")
    public List<String> obtenerProductos(@PathVariable int cedula)  {
        return clienteServicio.obtenerProductosAgregados(cedula);
    }
/**
 * ,
 *   "clienteDto": {
 *     "cedula": "123",
 *     "nombre": "Juan"
 *   }
 */
    /*

    @GetMapping("/productos")
    @ResponseBody
    public ArrayList<Producto> visualizarProductos() throws ProductoException {

        return clienteServicio.visualizarProductos();
    }

    @PostMapping("/agregar/{cantidad}")
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
*/
}
