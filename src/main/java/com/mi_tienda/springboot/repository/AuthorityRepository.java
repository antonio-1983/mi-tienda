package com.mi_tienda.springboot.repository;

import com.mi_tienda.springboot.entity.Authority;
import java.util.Optional;
import com.mi_tienda.springboot.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByName(AuthorityName name);
}
