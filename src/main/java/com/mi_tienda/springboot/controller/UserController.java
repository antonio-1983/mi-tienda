package com.mi_tienda.springboot.controller;

import com.mi_tienda.springboot.entity.User;
import com.mi_tienda.springboot.service.impl.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/hola")
    public String hola (){
        return "hola mundo";
    }
    @GetMapping("/ver")
    public ResponseEntity<List<User>> verUser(){
        try {
            List<User> users =userService.verUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
