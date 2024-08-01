package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Long>{
   
}
