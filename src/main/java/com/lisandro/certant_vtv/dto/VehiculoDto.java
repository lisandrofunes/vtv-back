package com.lisandro.certant_vtv.dto;

import com.lisandro.certant_vtv.entity.Modelo;
import com.lisandro.certant_vtv.entity.Propietario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehiculoDto {
    @NotBlank
    private String dominio;
    @NotNull
    private Modelo modelo;
    @NotNull
    private Propietario propietario;

    public VehiculoDto(@NotBlank String dominio, @NotNull Modelo modelo, @NotNull Propietario propietario) {
        this.dominio = dominio;
        this.modelo = modelo;
        this.propietario = propietario;
    }    
}
