package com.lisandro.certant_vtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisandro.certant_vtv.dto.PropietarioDto;
import com.lisandro.certant_vtv.entity.Propietario;
import com.lisandro.certant_vtv.service.PropietarioService;

@RestController
@RequestMapping("/propietario")
@CrossOrigin("*")
public class PropietarioController {
    
    @Autowired
    PropietarioService propietarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Propietario>> findAll(){

        List<Propietario> list = propietarioService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PropietarioDto propietarioDto){
        
        try {
            Propietario propietarioNuevo = new Propietario(
            propietarioDto.getNombre(),
            propietarioDto.getApellido(),
            propietarioDto.getDni(),
            propietarioDto.getTelefono(),
            propietarioDto.getEmail()
        );

        propietarioService.save(propietarioNuevo);
        return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }   
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PropietarioDto propietarioDto){
        
        if(!propietarioService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Propietario propietario = propietarioService.findById(id).get();

        propietario.setNombre(propietarioDto.getNombre());
        propietario.setApellido(propietarioDto.getApellido());
        propietario.setDni(propietarioDto.getDni());
        propietario.setTelefono(propietarioDto.getTelefono());
        propietario.setEmail(propietarioDto.getEmail());

        propietarioService.save(propietario);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){

        if(!propietarioService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        propietarioService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/by/{dni}")
    public ResponseEntity<Propietario> findByDni(@PathVariable("dni")String dni){

        Propietario propietario = propietarioService.findByDni(dni).get();

        return new ResponseEntity<>(propietario, HttpStatus.OK);
    }

}
