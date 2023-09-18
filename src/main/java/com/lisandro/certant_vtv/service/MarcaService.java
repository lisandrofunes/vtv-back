package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Marca;
import com.lisandro.certant_vtv.repository.MarcaRepository;

@Service
@Transactional
public class MarcaService {
    
    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> findAll(){
        return marcaRepository.findAll();
    }

    public Optional<Marca> findById(int id){
        return marcaRepository.findById(id);
    }

    public Optional<Marca> findByNombre(String nombre){
        return marcaRepository.findByNombre(nombre);
    }

    public boolean existsById(int id){
        return marcaRepository.existsById(id);
    }

    public void save(Marca marca){
        marcaRepository.save(marca);
    }

    public void deleteById(int id){
        marcaRepository.deleteById(id);
    }

}
