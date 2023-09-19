package com.lisandro.certant_vtv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisandro.certant_vtv.dto.InspeccionDto;
import com.lisandro.certant_vtv.entity.Propietario;
import com.lisandro.certant_vtv.entity.Vehiculo;
import com.lisandro.certant_vtv.entity.Estado;
import com.lisandro.certant_vtv.entity.Inspeccion;
import com.lisandro.certant_vtv.entity.Modelo;
import com.lisandro.certant_vtv.service.PropietarioService;
import com.lisandro.certant_vtv.service.VehiculoService;
import com.lisandro.certant_vtv.service.EstadoService;
import com.lisandro.certant_vtv.service.InspeccionService;
import com.lisandro.certant_vtv.service.ModeloService;

@RestController
@RequestMapping("/inspeccion")
@CrossOrigin("*")
public class InspeccionController {
    
    @Autowired
    InspeccionService inspeccionService;

    @Autowired
    PropietarioService propietarioService;

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    ModeloService modeloService;

    @Autowired
    EstadoService estadoService;

    @GetMapping("/list")
    public ResponseEntity<List<Inspeccion>> findAll(){

        List<Inspeccion> list = inspeccionService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
        
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody InspeccionDto inspeccionDto){
        try {
            String propietarioDni = inspeccionDto.getVehiculo().getPropietario().getDni();
            Optional<Propietario> propietarioOptional = propietarioService.findByDni(propietarioDni);
            Propietario propietario = propietarioOptional.orElse(null); // En caso de que no se encuentre, asigna null
/*             Propietario propietario = propietarioService.findByDni(propietarioDni).get();
 */

            System.out.println("Propietario: " + propietario);
            if(propietario == null){
                try {
                    Propietario propietarioNuevo = new Propietario(
                        inspeccionDto.getVehiculo().getPropietario().getNombre(),
                        inspeccionDto.getVehiculo().getPropietario().getApellido(),
                        inspeccionDto.getVehiculo().getPropietario().getDni(),
                        inspeccionDto.getVehiculo().getPropietario().getTelefono(),
                        inspeccionDto.getVehiculo().getPropietario().getEmail()
                    );
                    propietarioService.save(propietarioNuevo);

                    propietario = propietarioNuevo;
                    
                    System.out.println("prop creado");
                } catch (Exception e) {
                    return new ResponseEntity<>("No se pudo crear el propietario",HttpStatus.BAD_REQUEST);
                }
               
            }

            String vehiculoDominio = inspeccionDto.getVehiculo().getDominio();
            Optional<Vehiculo> vehiculoOptional = vehiculoService.findByDominio(vehiculoDominio);
            Vehiculo vehiculo = vehiculoOptional.orElse(null); 

            System.out.println("Vehiculo: " + vehiculo);

            if(vehiculo == null){

                String modeloNombre = inspeccionDto.getVehiculo().getModelo().getNombre();
                Optional<Modelo> modeloOptional = modeloService.findByNombre(modeloNombre);
                Modelo modelo = modeloOptional.orElse(null);

                if (modelo == null) {
                    try {
                        Modelo modeloNuevo = new Modelo(
                            inspeccionDto.getVehiculo().getModelo().getNombre(),
                            inspeccionDto.getVehiculo().getModelo().getMarca()
                        );
                        modeloService.save(modeloNuevo);
                        modelo = modeloNuevo; 
                    } catch (Exception e) {
                        return new ResponseEntity<>("No se pudo crear el modelo",HttpStatus.BAD_REQUEST);
                    }
                }
                
                try {
                    Vehiculo vehiculoNuevo = new Vehiculo(
                        inspeccionDto.getVehiculo().getDominio(),
                        modelo,
                        propietario
                        /*propietarioService.findByDni(propietario.getDni()).get()*/
                    );
                    vehiculoService.save(vehiculoNuevo);
                    vehiculo = vehiculoNuevo;
                    System.out.println("vehi creado");
                    
                } catch (Exception e) {
                    return new ResponseEntity<>("No se pudo crear el vehiculo",HttpStatus.BAD_REQUEST);
                }
            }

            Inspeccion inspeccion = new Inspeccion(
                inspeccionDto.getFecha(),
                inspeccionDto.getHora(),
                // propietarioService.findByDni(propietario.getDni()).get(),
                vehiculoService.findByDominio(vehiculo.getDominio()).get(),
                inspeccionDto.getInspector(),
                inspeccionDto.getEstado(),
                inspeccionDto.getEsExento()
            );

            inspeccionService.save(inspeccion);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

/*     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody InspeccionDto inspeccionDto){
        
        if(!inspeccionService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Inspeccion inspeccion = inspeccionService.findById(id).get();
        inspeccion.setDominio(inspeccionDto.getDominio());
        inspeccion.setModelo(inspeccionDto.getModelo());
        inspeccion.setPropietario(inspeccionDto.getPropietario());
        
        inspeccionService.save(inspeccion);

        return new ResponseEntity<>(HttpStatus.OK);
    } */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){

        if(!inspeccionService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        inspeccionService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Inspeccion> getById(@PathVariable("id") int id){
        if(!inspeccionService.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Inspeccion inspeccion = inspeccionService.getOne(id).get();
        return new ResponseEntity<>(inspeccion, HttpStatus.OK);
    }   

    
    @GetMapping("/listbyvehiculo/{id}")
    public ResponseEntity<Inspeccion> findByVehiculo(@PathVariable("id") int id){

        Vehiculo vehiculo = vehiculoService.findById(id).get();
        
        Inspeccion inspeccion = inspeccionService.findByVehiculo(vehiculo).get();

        return new ResponseEntity<>(inspeccion, HttpStatus.OK);
    }

    @GetMapping("/listbyestado/{id}")
    public ResponseEntity<List<Inspeccion>> findByEstado(@PathVariable("id") int id){

        try {
            Estado estado = estadoService.findById(id).get();

            List<Inspeccion> list = inspeccionService.findByEstado(estado);
            
            return new ResponseEntity<>(list, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        
        
    }

}
