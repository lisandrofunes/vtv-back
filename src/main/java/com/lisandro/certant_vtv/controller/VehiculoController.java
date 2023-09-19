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

import com.lisandro.certant_vtv.dto.VehiculoDto;
import com.lisandro.certant_vtv.entity.Propietario;
import com.lisandro.certant_vtv.entity.Vehiculo;
import com.lisandro.certant_vtv.service.PropietarioService;
import com.lisandro.certant_vtv.service.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")
public class VehiculoController {
    
    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    PropietarioService propietarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Vehiculo>> findAll(){

        List<Vehiculo> list = vehiculoService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehiculoDto vehiculoDto){
        try {
            String propietarioDni = vehiculoDto.getPropietario().getDni();
            Propietario propVehiculo = propietarioService.findByDni(propietarioDni).get();

            if(propVehiculo != null){

                Vehiculo vehiculoNuevo = new Vehiculo(
                    vehiculoDto.getDominio(), 
                    vehiculoDto.getModelo(),
                    propVehiculo
                );
                vehiculoService.save(vehiculoNuevo);

            } else {
                Propietario propietarioNuevo = new Propietario(
                    vehiculoDto.getPropietario().getNombre(),
                    vehiculoDto.getPropietario().getApellido(),
                    vehiculoDto.getPropietario().getDni(),
                    vehiculoDto.getPropietario().getTelefono(),
                    vehiculoDto.getPropietario().getEmail()
                );
                propietarioService.save(propietarioNuevo);

                Vehiculo vehiculoNuevo = new Vehiculo(
                    vehiculoDto.getDominio(), 
                    vehiculoDto.getModelo(),
                    propietarioNuevo
                );
                vehiculoService.save(vehiculoNuevo);
            }
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody VehiculoDto vehiculoDto){
        
        if(!vehiculoService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Vehiculo vehiculo = vehiculoService.findById(id).get();
        vehiculo.setDominio(vehiculoDto.getDominio());
        vehiculo.setModelo(vehiculoDto.getModelo());
        vehiculo.setPropietario(vehiculoDto.getPropietario());
        
        vehiculoService.save(vehiculo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){

        if(!vehiculoService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        vehiculoService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    @GetMapping("/listbyprop/{id}")
    public ResponseEntity<List<Vehiculo>> findByPropietario(@PathVariable("id") int id){

        Propietario propietario = propietarioService.findById(id).get();

        List<Vehiculo> list = vehiculoService.findByPropietario(propietario);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
