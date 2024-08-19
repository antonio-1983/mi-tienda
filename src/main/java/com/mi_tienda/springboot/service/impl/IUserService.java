package com.mi_tienda.springboot.service.impl;

import com.mi_tienda.springboot.entity.User;
import java.util.List;

public interface IUserService {
    
    public List<User> verUsers();
    public void crearUser(User user);
    public void editarUser(Long id,User user);
    public User buscarUser(Long id); 
}
