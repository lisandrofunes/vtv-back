package com.lisandro.certant_vtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisandro.certant_vtv.dto.EstadoDto;
import com.lisandro.certant_vtv.entity.Estado;
import com.lisandro.certant_vtv.service.EstadoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/estado")
@CrossOrigin("*")
public class EstadoController {
    
    @Autowired
    EstadoService estadoService;

    @GetMapping("/list")
    public ResponseEntity<List<Estado>> findAll(){

        List<Estado> list = estadoService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EstadoDto estadoDto){

        if(estadoDto.getNombre().isBlank()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Estado estadoNuevo = new Estado(estadoDto.getNombre());
        estadoService.save(estadoNuevo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EstadoDto estadoDto){
        
        if(!estadoService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Estado estado = estadoService.findById(id).get();
        estado.setNombre(estadoDto.getNombre());
        estadoService.save(estado);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){

        if(!estadoService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        estadoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
