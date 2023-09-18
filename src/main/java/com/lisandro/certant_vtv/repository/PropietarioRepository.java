package com.lisandro.certant_vtv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.certant_vtv.entity.Propietario;
import java.util.Optional;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer>{
    Optional<Propietario> findByDni(String dni);
}
