package com.mi_tienda.springboot.controller;

import com.mi_tienda.springboot.entity.User;
import com.mi_tienda.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Crear un nuevo usuario
    @PostMapping("/crear")
    public ResponseEntity<User> crearUser(@RequestBody User user) {
        userService.crearUser(user);
        return ResponseEntity.ok(user);
    }

    // Obtener todos los usuarios
    @GetMapping("/ver")
    public ResponseEntity<List<User>> verUsers() {
        List<User> users = userService.verUsers();
        return ResponseEntity.ok(users);
    }

    // Obtener un usuario por su ID
    @GetMapping("/ver/{id}")
    public ResponseEntity<User> verUserPorId(@PathVariable Long id) {
        User user = userService.buscarUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar un usuario por su ID
    @PutMapping("/editar/{id}")
    public ResponseEntity<User> editarUser(@PathVariable Long id, @RequestBody User userDetalles) {
        try {
            userService.editarUser(id, userDetalles);
            return ResponseEntity.ok(userDetalles);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por su ID
    /*
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUser(@PathVariable Long id) {
        try {
            userService.eliminarUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    */
}

