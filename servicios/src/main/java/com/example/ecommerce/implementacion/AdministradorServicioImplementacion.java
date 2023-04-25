package com.example.ecommerce.implementacion;
import com.example.ecommerce.entidades.Producto;
import com.example.ecommerce.repositorios.AdministradorRepositorio;
import com.example.ecommerce.repositorios.ProductoRepositorio;
import com.example.ecommerce.servicios.AdministradorServicio;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServicioImplementacion implements AdministradorServicio {
    //private final AdministradorRepositorio administradorRepositorio;
    private final AdministradorRepositorio administradorRepositorio;
    private final ProductoRepositorio productoRepositorio;


    public AdministradorServicioImplementacion(AdministradorRepositorio administradorRepositorio, ProductoRepositorio productoRepositorio) {
        this.administradorRepositorio = administradorRepositorio;
        this.productoRepositorio = productoRepositorio;
    }


    @Override
    public Producto crearProducto(String nombre, String referencia, String urlFoto, int cantidad, String categoria) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setReferencia(referencia);
        producto.setUrlFoto(urlFoto);
        producto.setCantidad(cantidad);
        producto.setCategoria(categoria);
        return productoRepositorio.save(producto);
    }
}
