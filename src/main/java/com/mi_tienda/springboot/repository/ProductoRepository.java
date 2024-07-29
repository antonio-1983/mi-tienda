package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
}
