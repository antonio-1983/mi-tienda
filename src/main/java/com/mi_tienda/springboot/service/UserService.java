package com.mi_tienda.springboot.service;

import com.mi_tienda.springboot.entity.User;
import com.mi_tienda.springboot.repository.UserRepository;
import com.mi_tienda.springboot.service.impl.IUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService implements IUserService{
    
    @Autowired
    public UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<User> verUsers() {
      return userRepository.findAll();
    }

    @Override
    public void crearUser(User user) {
         user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User buscarUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(User user, String rawPassword) {
                // Usa PasswordEncoder para comparar contraseñas
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }   
    
    @Override
    public void editarUser(Long id, User userDetalles) {
        Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
        User userExistente = optionalUser.get();
        
        if (userDetalles.getNombre() != null) {
            userExistente.setNombre(userDetalles.getNombre());
        }
        // Asegúrate de codificar la contraseña si se ha cambiado
        if(userDetalles.getPassword() != null && !userDetalles.getPassword().isEmpty()){
                userExistente.setPassword(passwordEncoder.encode(userDetalles.getPassword()));
        }       
        if (userDetalles.getApellido() != null) {
            userExistente.setApellido(userDetalles.getApellido());
        }
        if (userDetalles.getEmail() != null) {
            userExistente.setEmail(userDetalles.getEmail());
        }
        if (userDetalles.getTelefono() != 0) {
            userExistente.setTelefono(userDetalles.getTelefono());
        }          
            userRepository.save(userExistente);
    } else {
        throw new RuntimeException("Usuario no encontrado");
    }
   }
}
