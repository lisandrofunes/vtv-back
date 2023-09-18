package com.lisandro.certant_vtv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dominio;
    @OneToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
    @ManyToOne
    @JoinColumn(name = "id_prop")
    private Propietario propietario;
    
    public Vehiculo(String dominio, Modelo modelo, Propietario propietario) {
        this.dominio = dominio;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    
}
