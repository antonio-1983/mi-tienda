package com.mi_tienda.springboot.controller;
import com.mi_tienda.springboot.entity.Producto;
import com.mi_tienda.springboot.service.impl.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
   
    @Autowired
    private IProductoService productoService;
   
    @GetMapping("/hola")
    public String home (){
        return "hola producto";
    }
    
    @GetMapping("/ver")
    public ResponseEntity<List<Producto>> verProducto(){
        try {
            List<Producto> productos =productoService.verProductos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    } 
}

