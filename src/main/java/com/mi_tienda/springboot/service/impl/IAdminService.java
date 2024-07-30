package com.mi_tienda.springboot.service.impl;

import com.mi_tienda.springboot.entity.Admin;
import java.util.List;


public interface IAdminService {
    
    public List<Admin> verAdmins();
    public void crearAdmin(Admin admin);
    public void editarAdmin(Long id,Admin admin);
    public Admin buscarAdmin(Long id);
    
}
