package com.lisandro.certant_vtv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lisandro.certant_vtv.entity.Propietario;
import com.lisandro.certant_vtv.repository.PropietarioRepository;

@Service
@Transactional
public class PropietarioService {
    
    @Autowired
    PropietarioRepository propietarioRepository;

    public List<Propietario> findAll(){
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> findById(int id){
        return propietarioRepository.findById(id);
    }

    public Optional<Propietario> findByDni(String dni){
        return propietarioRepository.findByDni(dni);
    }

    public void save(Propietario propietario){
        propietarioRepository.save(propietario);
    }

    public void deleteById(int id){
        propietarioRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return propietarioRepository.existsById(id);
    }

}
