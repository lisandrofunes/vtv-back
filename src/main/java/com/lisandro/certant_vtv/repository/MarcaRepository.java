package com.lisandro.certant_vtv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.certant_vtv.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{
    Optional<Marca> findByNombre (String nombre);
}
