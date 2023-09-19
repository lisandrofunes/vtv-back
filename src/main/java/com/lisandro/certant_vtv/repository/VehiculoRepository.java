package com.lisandro.certant_vtv.repository;

import com.lisandro.certant_vtv.entity.Propietario;
import com.lisandro.certant_vtv.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;



@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{
    Optional<Vehiculo> findByDominio(String dominio);    
    List<Vehiculo> findByPropietario(Propietario propietario);
}
