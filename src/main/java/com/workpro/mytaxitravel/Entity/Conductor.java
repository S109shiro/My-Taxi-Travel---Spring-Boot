package com.workpro.mytaxitravel.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
@Entity
@Table(name = "tb_conductor")
public class Conductor extends Persona{
    @Id  // Indica el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Indica que es autoincremental

    @JsonProperty("id_conductor")
    @Column(name = "id_conductor") // Configura la columna y las posibles restricciones
    private int idConductor;

    @JsonProperty("calificacion_media")
    @Column(name = "calificacion_media", nullable = false)
    private double calificacionMedia;

    @JsonProperty("ganancias_mes")
    @Column(name = "ganancias_mes", nullable = false)
    private double gananciasMes;

    @JsonProperty("ganancias_totales")
    @Column(name = "ganancias_totales", nullable = false)
    private double gananciasTotales;


    // Indicamos relacion
    @OneToOne
    // Nombre que tendra la union de columnas
    @JoinColumn(name = "taxi_en_uso")
    // Invocacion del objeto a referenciar (clase primaria)
    @JsonProperty("taxi_en_uso")
    private Taxi taxiEnUso;

}
