package com.mi_tienda.springboot.controller;

import com.mi_tienda.springboot.entity.Producto;
import com.mi_tienda.springboot.service.impl.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // Crear un nuevo producto
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return ResponseEntity.ok(producto);
    }

    // Obtener todos los productos
    @GetMapping("/ver")
    public ResponseEntity<List<Producto>> verProductos() {
        List<Producto> productos = productoService.verProductos();
        return ResponseEntity.ok(productos);
    }

    // Obtener un producto por su ID
    @GetMapping("/ver/{id}")
    public ResponseEntity<Producto> verProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.buscarProducto(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un producto por su ID
    @PutMapping("/editar/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        try {
            productoService.editarProducto(id, productoDetalles);
            return ResponseEntity.ok(productoDetalles);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


