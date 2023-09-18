package com.lisandro.certant_vtv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.certant_vtv.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
}
