package com.workpro.mytaxitravel.Entity;

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
    @Column(name = "id_conductor") // Configura la columna y las posibles restricciones
    private int idConductor;
    @Column(name = "calificacion_media", nullable = false)
    private double calificacionMedia;
    @Column(name = "ganancias_mes", nullable = false)
    private double gananciasMes;
    @Column(name = "ganancias_totales", nullable = false)
    private double gananciasTotales;

    // Indicamos relacion
    @OneToOne
    // Nombre que tendra la union de columnas
    @JoinColumn(name = "taxi_en_uso")
    // Invocacion del objeto a referenciar (clase primaria)
    private Taxi taxiEnUso;

}
