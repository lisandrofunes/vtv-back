package com.lisandro.certant_vtv.dto;

import java.util.List;

import com.lisandro.certant_vtv.entity.Persona;
import com.lisandro.certant_vtv.entity.Vehiculo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropietarioDto extends Persona{
    private List<Vehiculo> vehiculo;

    public PropietarioDto(String nombre, String apellido, String dni, String telefono, String email) {
        super(nombre, apellido, dni, telefono, email);
    }
    
}
