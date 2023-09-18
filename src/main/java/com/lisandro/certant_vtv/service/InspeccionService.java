package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Estado;
import com.lisandro.certant_vtv.entity.Inspeccion;
import com.lisandro.certant_vtv.repository.InspeccionRepository;

@Service
@Transactional
public class InspeccionService {
    
    @Autowired
    InspeccionRepository inspeccionRepository;

    public List<Inspeccion> findAll(){
        return inspeccionRepository.findAll();
    }

    public Optional<Inspeccion> getOne(int id){
        return inspeccionRepository.findById(id);
    }

    public Optional<Inspeccion> findByEstado(Estado estado){
        return inspeccionRepository.findByEstado(estado);
    }

    public void save(Inspeccion inspeccion){
        inspeccionRepository.save(inspeccion);
    }

    public void deleteById(int id){
        inspeccionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return inspeccionRepository.existsById(id);
    }
}
