package com.lisandro.certant_vtv.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Propietario extends Persona{

    @OneToMany(mappedBy = "propietario")
    @JsonBackReference
    private List<Vehiculo> vehiculo;

    public Propietario(String nombre, String apellido, String dni, String telefono, String email) {
        super(nombre, apellido, dni, telefono, email);
    }
}
