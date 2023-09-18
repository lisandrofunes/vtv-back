package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Marca;
import com.lisandro.certant_vtv.entity.Modelo;
import com.lisandro.certant_vtv.repository.ModeloRepository;

@Service
@Transactional
public class ModeloService {
    
    @Autowired
    ModeloRepository modeloRepository;

    public List<Modelo> findAll(){
        return modeloRepository.findAll();
    }

    public Optional<Modelo> findById(int id){
        return modeloRepository.findById(id);
    }

    public Optional<Modelo> findByNombre(String nombre){
        return modeloRepository.findByNombre(nombre);
    }

    public boolean existsById(int id){
        return modeloRepository.existsById(id);
    }

    public void save(Modelo modelo){
        modeloRepository.save(modelo);
    }

    public void deleteById(int id){
        modeloRepository.deleteById(id);
    }

    public List<Modelo> findByMarca(Marca marca){
        return modeloRepository.findByMarca(marca);
    }

}
