package com.workpro.mytaxitravel.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@Data

@Entity
@Table(name = "tb_viaje")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viaje")
    @JsonProperty("id_viaje")
    private int idViaje;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonProperty("id_usuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_conductor", nullable = false)
    @JsonProperty("id_conductor")
    private Conductor idConductor;

    @Column(name = "estado_viaje", nullable = false)
    @JsonProperty("estado_viaje")
    private String estadoViaje;

    @Column(name = "costo_final", nullable = false, precision = 10, scale = 2)
    @JsonProperty("costo_final")
    private BigDecimal costoFinal;

    @Column(name = "tipo_pago", nullable = false, length = 60)
    @JsonProperty("tipo_pago")
    private String tipoPago;

    @OneToOne
    @JoinColumn(name = "calificacion_final", nullable = false)
    @JsonProperty("calificacion_final")
    private Calificacion calificacionFinal;

    @OneToOne
    @JoinColumn(name = "reporte", nullable = true)
    @JsonProperty("reporte")
    private Reporte reporte;

    @OneToOne
    @JoinColumn(name = "registro_GPS", nullable = false)
    @JsonProperty("registro_GPS")
    private RegistroGPS registroGPS;

}
