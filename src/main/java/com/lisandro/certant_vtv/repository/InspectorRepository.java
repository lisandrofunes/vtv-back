package com.lisandro.certant_vtv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lisandro.certant_vtv.entity.Inspector;

public interface InspectorRepository extends JpaRepository<Inspector, Integer>{
    Optional<Inspector> findByDni(String dni);
    Optional<Inspector> findByNombre(String nombre);
}
