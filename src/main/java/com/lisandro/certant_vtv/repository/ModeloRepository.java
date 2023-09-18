package com.lisandro.certant_vtv.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.certant_vtv.entity.Marca;
import com.lisandro.certant_vtv.entity.Modelo;


@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer>{
    Optional<Modelo> findByNombre (String nombre);
    List<Modelo> findByMarca(Marca marca);
}
