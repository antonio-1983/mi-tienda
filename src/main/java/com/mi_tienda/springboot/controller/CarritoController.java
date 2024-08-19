package com.mi_tienda.springboot.controller;

import com.mi_tienda.springboot.entity.Carrito;
import com.mi_tienda.springboot.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/{userId}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Long userId) {
        Carrito carrito = carritoService.obtenerCarritoPorUserId(userId);
        return ResponseEntity.ok(carrito);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Carrito> agregarProductoAlCarrito(
            @RequestParam Long userId,
            @RequestParam Long productoId,
            @RequestParam int cantidad) {
        Carrito carrito = carritoService.agregarProductoAlCarrito(userId, productoId, cantidad);
        return ResponseEntity.ok(carrito);
    }

    @DeleteMapping("/eliminar/{carritoItemId}")
    public ResponseEntity<Void> eliminarProductoDelCarrito(@PathVariable Long carritoItemId) {
        carritoService.eliminarProductoDelCarrito(carritoItemId);
        return ResponseEntity.noContent().build();
    }
}

