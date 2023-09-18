package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Inspector;
import com.lisandro.certant_vtv.repository.InspectorRepository;

@Service
@Transactional
public class InspectorService {
    
    @Autowired
    InspectorRepository inspectorRepository;

        public List<Inspector> findAll(){
        return inspectorRepository.findAll();
    }

    public Optional<Inspector> findById(int id){
        return inspectorRepository.findById(id);
    }

    public Optional<Inspector> findByDni(String dni){
        return inspectorRepository.findByDni(dni);
    }

    public Optional<Inspector> findByNombre(String nombre){
        return inspectorRepository.findByNombre(nombre);
    }

    public boolean existsById(int id){
        return inspectorRepository.existsById(id);
    }

    public void save(Inspector inspector){
        inspectorRepository.save(inspector);
    }

    public void deleteById(int id){
        inspectorRepository.deleteById(id);
    }

}
