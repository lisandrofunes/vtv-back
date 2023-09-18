package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Estado;
import com.lisandro.certant_vtv.repository.EstadoRepository;

@Service
@Transactional
public class EstadoService {
    
    @Autowired
    EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public boolean existsById(int id){
        return estadoRepository.existsById(id);
    }

    public Optional<Estado> findById(int id){
        return estadoRepository.findById(id);
    }

    public void save(Estado estado){
        estadoRepository.save(estado);
    }

    public void deleteById(int id){
        estadoRepository.deleteById(id);
    }

}
