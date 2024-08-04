package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//agregado
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
}
