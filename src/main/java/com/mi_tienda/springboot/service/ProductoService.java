package com.mi_tienda.springboot.service;
import com.mi_tienda.springboot.entity.Producto;
import com.mi_tienda.springboot.repository.ProductoRepository;
import com.mi_tienda.springboot.service.impl.IProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public List<Producto> verProductos(){
        return productoRepository.findAll();
    }
    @Override
    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }
        @Override
    public Producto buscarProducto(Long id){
        return productoRepository.findById(id).orElse(null);
    }
    @Override
    public void eliminarProducto(Long id){
       productoRepository.deleteById(id);
    }
    @Override
    public void editarProducto(Long id,Producto productoDetalles){

              Optional<Producto> optionalProducto = productoRepository.findById(id);
    if (optionalProducto.isPresent()) {
        Producto productoExistente = optionalProducto.get();
        
        if (productoDetalles.getNombre() != null) {
            productoExistente.setNombre(productoDetalles.getNombre());
        }     
        if (productoDetalles.getPrecio() != 0) {
            productoExistente.setPrecio(productoDetalles.getPrecio());
        }
        if (productoDetalles.getStock() != null) {
            productoExistente.setStock(productoDetalles.getStock());
        }
        if (productoDetalles.getDescripcion() != null) {
            productoExistente.setDescripcion(productoDetalles.getDescripcion());
        }  
        if (productoDetalles.getImg_producto() != null) {
            productoExistente.setImg_producto(productoDetalles.getImg_producto());
        }
            productoRepository.save(productoExistente);
    } else {
        throw new RuntimeException("Producto no encontrado");
    }

    }
    

}
