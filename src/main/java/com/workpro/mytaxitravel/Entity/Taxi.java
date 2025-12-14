package com.workpro.mytaxitravel.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

@Data
@Entity
@Table(name = "tb_taxi")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_taxi")
    private int idTaxi;
    @Column(name = "placa", length = 6, unique = true, nullable = false)
    private String placa;
    @Column(name = "modelo", nullable = false)
    private String modelo;
    @Column(name = "ultima_tecnico_mecanica", nullable = false)
    private Date ultimaTecnicoMecanica;

    // Creamos la relacion entre las dos tablas
    @OneToOne
    // Comentamos que vamos a hacer una union de columnas con una clase ya creada
    @JoinColumn(name = "conductor_encargado")
    // Creamos una variable con esa clase que queremos ingresar en esta tabla
    private Conductor conductor;
}
