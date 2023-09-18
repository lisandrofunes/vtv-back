package com.lisandro.certant_vtv.dto;

import com.lisandro.certant_vtv.entity.Marca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModeloDto {
    @NotBlank
    private String nombre;
    @NotNull
    private Marca marca;

    public ModeloDto(String nombre,Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }    
}
