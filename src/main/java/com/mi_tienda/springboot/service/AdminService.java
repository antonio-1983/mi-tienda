package com.mi_tienda.springboot.service;

import com.mi_tienda.springboot.entity.Admin;
import com.mi_tienda.springboot.repository.AdminRepository;
import com.mi_tienda.springboot.service.impl.IAdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AdminService implements IAdminService{
    
    @Autowired
    public AdminRepository adminRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<Admin> verAdmins() {
      return adminRepository.findAll();
    }

    @Override
    public void crearAdmin(Admin admin) {
         admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }

    @Override
    public Admin buscarAdmin(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    public Optional<Admin> findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public boolean checkPassword(Admin admin, String rawPassword) {
                // Usa PasswordEncoder para comparar contraseñas
        return passwordEncoder.matches(rawPassword, admin.getPassword());
    }   
    
    @Override
    public void editarAdmin(Long id, Admin adminDetalles) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
    if (optionalAdmin.isPresent()) {
        Admin adminExistente = optionalAdmin.get();
        // Asegúrate de codificar la contraseña si se ha cambiado
        if(adminDetalles.getPassword() != null && !adminDetalles.getPassword().isEmpty()){
                adminExistente.setPassword(passwordEncoder.encode(adminDetalles.getPassword()));
        }
        if(adminDetalles.getUsername()!=null){
            adminExistente.setUsername(adminDetalles.getUsername());
        }
        if (adminDetalles.getEmail() != null) {
            adminExistente.setEmail(adminDetalles.getEmail());
        }
        if (adminDetalles.getTelefono() != 0) {
            adminExistente.setTelefono(adminDetalles.getTelefono());
        }          
            adminRepository.save(adminExistente);
    } else {
        throw new RuntimeException("Admin no encontrado");
    }
   }
}

