package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito,Long>{
    
}
