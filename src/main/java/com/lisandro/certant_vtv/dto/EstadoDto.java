package com.lisandro.certant_vtv.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstadoDto {
    private String nombre;

    public EstadoDto(String nombre){
        this.nombre = nombre;
    }
}


