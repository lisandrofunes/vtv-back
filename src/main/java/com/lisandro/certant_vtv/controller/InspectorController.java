package com.lisandro.certant_vtv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisandro.certant_vtv.dto.InspectorDto;
import com.lisandro.certant_vtv.entity.Inspector;
import com.lisandro.certant_vtv.service.InspectorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/inspector")
@CrossOrigin("*")
public class InspectorController {
    
    @Autowired
    InspectorService inspectorService;

    @GetMapping("/list")
    public ResponseEntity<List<Inspector>> findAll(){

        List<Inspector> list = inspectorService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody InspectorDto inspectorDto){

        if(inspectorDto.getNombre().isBlank()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Inspector inspectorNuevo = new Inspector(
            inspectorDto.getNombre(),
            inspectorDto.getApellido(),
            inspectorDto.getDni(),
            inspectorDto.getTelefono(),
            inspectorDto.getEmail(),
            inspectorDto.getLegajo()
        );

        inspectorService.save(inspectorNuevo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody InspectorDto inspectorDto){
        
        if(!inspectorService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Inspector inspector = inspectorService.findById(id).get();

        inspector.setNombre(inspectorDto.getNombre());
        inspector.setApellido(inspectorDto.getApellido());
        inspector.setDni(inspectorDto.getDni());
        inspector.setTelefono(inspectorDto.getTelefono());
        inspector.setEmail(inspectorDto.getEmail());
        inspector.setLegajo(inspectorDto.getLegajo());

        inspectorService.save(inspector);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){

        if(!inspectorService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        inspectorService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
