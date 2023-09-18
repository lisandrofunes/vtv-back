package com.lisandro.certant_vtv.dto;

import java.sql.Date;
import java.time.LocalTime;

import com.lisandro.certant_vtv.entity.Estado;
import com.lisandro.certant_vtv.entity.Inspector;
import com.lisandro.certant_vtv.entity.Vehiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InspeccionDto {
    @NotBlank
    private Date fecha;
    @NotBlank
    private LocalTime hora;
    @NotNull
    private Vehiculo vehiculo;
    @NotNull
    private Inspector inspector;
    @NotNull
    private Estado estado;
    @NotBlank
    private Boolean esExento;
    
    public InspeccionDto(@NotBlank Date fecha, @NotBlank LocalTime hora,
            @NotNull Vehiculo vehiculo, @NotNull Inspector inspector, @NotNull Estado estado,
            @NotBlank Boolean esExento) {
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        this.inspector = inspector;
        this.estado = estado;
        this.esExento = esExento;
    }

    

}
