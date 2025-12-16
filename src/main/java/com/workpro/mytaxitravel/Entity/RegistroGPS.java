package com.workpro.mytaxitravel.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter

@Data

@Entity
@Table(name = "tb_registro_GPS")
public class RegistroGPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_viaje")
    private int idRegistroViaje;
    @Column(name = "direccion_inicio", nullable = false)
    private String direccionInicio;
    @Column(name = "direccion_destino", nullable = false)
    private String direccionDestino;
    @Column(name = "latitud_inicio", nullable = false)
    private BigDecimal latitudInicio;
    @Column(name = "longitud_inicio", nullable = false)
    private BigDecimal longitudInicio;
    @Column(name = "latitud_destino", nullable = false)
    private BigDecimal latitudDestino;
    @Column(name = "longitud_destino", nullable = false)
    private BigDecimal longitudDestino;
    @Column(name = "fecha_hora_inicio", nullable = false)
    private Date fechaHoraInicio;
    @Column(name = "fecha_hora_final", nullable = false)
    private Date fechaHoraFinal;
}
