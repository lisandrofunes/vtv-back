package com.lisandro.certant_vtv.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inspector extends Persona {
    
    private int legajo;

    public Inspector(String nombre, String apellido, String dni, String telefono, String email, int legajo) {
        super(nombre, apellido, dni, telefono, email);
        this.legajo = legajo;
    }

   
}
