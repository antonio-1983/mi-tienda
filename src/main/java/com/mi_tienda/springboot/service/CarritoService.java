package com.mi_tienda.springboot.service;

import com.mi_tienda.springboot.entity.Carrito;
import com.mi_tienda.springboot.repository.CarritoRepository;
import com.mi_tienda.springboot.service.impl.ICarritoService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService{
    CarritoRepository carritoRepository;
    
    @Override
    public List<Carrito> verCarritos(){
        return carritoRepository.findAll();
    }
    @Override
    public void crearCarrito(Carrito carrito){
        carritoRepository.save(carrito);
    }
    @Override
    public void editarCarrito(Long id,Carrito carritoDetalles){
        
        Optional<Carrito> optionalCarrito = carritoRepository.findById(id);
    if (optionalCarrito.isPresent()) {
        Carrito carritoExistente = optionalCarrito.get();
        
        if (carritoDetalles.getId_producto() != null) {
            carritoExistente.setId_producto(carritoDetalles.getId_producto());
        }     
        if (carritoDetalles.getId_user() != 0) {
            carritoExistente.setId_user(carritoDetalles.getId_user());
        }
        if (carritoDetalles.getTotal() != null) {
            carritoExistente.setTotal(carritoDetalles.getTotal());
        }
            carritoRepository.save(carritoExistente);
    } else {
        throw new RuntimeException("Producto no encontrado");
    }
    }
    @Override
    public void eliminarCarrito(Long id){
        carritoRepository.deleteById(id);
    }
    @Override
    public Carrito buscarCarrito(Long id){
        return carritoRepository.findById(id).orElse(null);
    }
}
