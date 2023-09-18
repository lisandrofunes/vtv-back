package com.lisandro.certant_vtv.entity;

import jakarta.persistence.Column;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inspeccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroInscripcion;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(columnDefinition = "TIME")
    private LocalTime hora;
    // @ManyToOne
    // @JoinColumn(name = "id_propietario")
    // private Propietario propietario;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    @ManyToOne
    @JoinColumn(name = "id_inspector")
    private Inspector inspector;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
    private Boolean esExento;

    public Inspeccion(Date fecha, LocalTime hora, Vehiculo vehiculo, Inspector inspector, Estado estado, Boolean esExento) {
        this.fecha = fecha;
        this.hora = hora;
        this.vehiculo = vehiculo;
        this.inspector = inspector;
        this.estado = estado;
        this.esExento = esExento;
    }

}
