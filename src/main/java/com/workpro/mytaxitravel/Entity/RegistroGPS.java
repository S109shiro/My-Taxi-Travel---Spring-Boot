package com.workpro.mytaxitravel.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter

@Data

@Entity
@Table(name = "tb_registro_GPS")
public class RegistroGPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_viaje")
    @JsonProperty("id_registro_viaje")
    private int idRegistroViaje;

    @Column(name = "direccion_inicio", nullable = false)
    @JsonProperty("direccion_inicio")
    private String direccionInicio;

    @Column(name = "direccion_destino", nullable = false)
    @JsonProperty("direccion_destino")
    private String direccionDestino;

    @Column(name = "latitud_inicio", nullable = false)
    @JsonProperty("latitud_inicio")
    private BigDecimal latitudInicio;

    @Column(name = "longitud_inicio", nullable = false)
    @JsonProperty("longitud_inicio")
    private BigDecimal longitudInicio;

    @Column(name = "latitud_destino", nullable = false)
    @JsonProperty("latitud_destino")
    private BigDecimal latitudDestino;

    @Column(name = "longitud_destino", nullable = false)
    @JsonProperty("longitud_destino")
    private BigDecimal longitudDestino;

    @Column(name = "fecha_hora_inicio", nullable = false)
    @JsonProperty("fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_final", nullable = false)
    @JsonProperty("fecha_hora_final")
    private LocalDateTime fechaHoraFinal;
}
