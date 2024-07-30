package com.mi_tienda.springboot.repository;
import com.mi_tienda.springboot.entity.Admin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin,Long>{
    Optional<Admin> findByUsername(String username);
}
