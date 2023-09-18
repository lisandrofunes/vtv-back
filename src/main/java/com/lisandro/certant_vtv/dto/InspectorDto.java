package com.lisandro.certant_vtv.dto;

import com.lisandro.certant_vtv.entity.Persona;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InspectorDto extends Persona{
    private int legajo;

    public InspectorDto(String nombre, String apellido, String dni, String telefono, String email, int legajo) {
        super(nombre, apellido, dni, telefono, email);
        this.legajo = legajo;
    }

}
