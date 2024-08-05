package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.Carrito;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito,Long>{
    Optional<Carrito> findByUserId(Long userId);
}
