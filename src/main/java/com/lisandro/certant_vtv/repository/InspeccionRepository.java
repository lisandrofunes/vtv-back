package com.lisandro.certant_vtv.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lisandro.certant_vtv.entity.Estado;
import com.lisandro.certant_vtv.entity.Inspeccion;
import com.lisandro.certant_vtv.entity.Vehiculo;

import java.util.List;
import java.util.Optional;


@Repository
public interface InspeccionRepository extends JpaRepository<Inspeccion, Integer>{
    List<Inspeccion> findByEstado(Estado estado);
    Optional<Inspeccion> findByVehiculo(Vehiculo vehiculo);
}
