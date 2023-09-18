package com.lisandro.certant_vtv.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarcaDto {
    private String nombre;

    public MarcaDto(String nombre){
        this.nombre = nombre;
    }
}
