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
@Table(name = "tb_taxi")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_taxi")
    @Column(name = "id_taxi")
    private int idTaxi;

    @JsonProperty("placa")
    @Column(name = "placa", length = 6, unique = true, nullable = false)
    private String placa;

    @JsonProperty("modelo")
    @Column(name = "modelo", nullable = false)
    private String modelo;

    @JsonProperty("ultima_tecnico_mecanica")
    @Column(name = "ultima_tecnico_mecanica", nullable = false)
    private Date ultimaTecnicoMecanica;
}
