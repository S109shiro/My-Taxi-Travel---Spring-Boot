package com.workpro.mytaxitravel.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

@Data

@Entity
@Table(name = "tb_reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    @JsonProperty("id_reporte")
    private int idReporte;


    @Column(name = "fecha_reporte", nullable = false)
    @JsonProperty("fecha_reporte")
    private Date fechaReporte;


    @Column(name = "tipo_reporte", nullable = false, length = 20)
    @JsonProperty("tipo_reporte")
    private String tipoReporte;


    @Column(name = "detalles", nullable = false)
    @JsonProperty("detalles")
    private String detalles;


    @ManyToOne
    @JoinColumn(name = "encargado_reporte", nullable = false)
    @JsonProperty("encargado_reporte")
    private Administrador encargado_reporte;

}
