package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
}
