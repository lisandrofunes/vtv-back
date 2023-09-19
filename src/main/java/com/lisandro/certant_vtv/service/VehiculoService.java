package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Propietario;
import com.lisandro.certant_vtv.entity.Vehiculo;
import com.lisandro.certant_vtv.repository.VehiculoRepository;

@Service
@Transactional
public class VehiculoService {
    
    @Autowired
    VehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAll(){
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> findById(int id){
        return vehiculoRepository.findById(id);
    }

    public void save(Vehiculo vehiculo){
        vehiculoRepository.save(vehiculo);
    }

    public void deleteById(int id){
        vehiculoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return vehiculoRepository.existsById(id);
    }

    public Optional<Vehiculo> findByDominio(String dominio) {
        return vehiculoRepository.findByDominio(dominio);
    }

    public List<Vehiculo> findByPropietario(Propietario propietario){
        return vehiculoRepository.findByPropietario(propietario);
    }

}
