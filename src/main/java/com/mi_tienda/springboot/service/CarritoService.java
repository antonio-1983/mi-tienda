package com.mi_tienda.springboot.service;

import com.mi_tienda.springboot.entity.Carrito;
import com.mi_tienda.springboot.entity.CarritoItem;
import com.mi_tienda.springboot.entity.Producto;
import com.mi_tienda.springboot.repository.CarritoItemRepository;
import com.mi_tienda.springboot.repository.CarritoRepository;
import com.mi_tienda.springboot.repository.ProductoRepository;
import com.mi_tienda.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UserRepository userRepository;

    public Carrito obtenerCarritoPorUserId(Long userId) {
        return carritoRepository.findByUserId(userId).orElse(null);
    }

    public Carrito agregarProductoAlCarrito(Long userId, Long productoId, int cantidad) {
        Optional<Carrito> carritoOptional = carritoRepository.findByUserId(userId);
        Carrito carrito;
        if (carritoOptional.isEmpty()) {
            carrito = new Carrito();
            carrito.setUser(userRepository.findById(userId).orElse(null));
        } else {
            carrito = carritoOptional.get();
        }

        Producto producto = productoRepository.findById(productoId).orElse(null);
        CarritoItem item = new CarritoItem();
        item.setCarrito(carrito);
        item.setProducto(producto);
        item.setCantidad(cantidad);

        carrito.getItems().add(item);
        carritoItemRepository.save(item);
        return carritoRepository.save(carrito);
    }

    public void eliminarProductoDelCarrito(Long carritoItemId) {
        carritoItemRepository.deleteById(carritoItemId);
    }
}