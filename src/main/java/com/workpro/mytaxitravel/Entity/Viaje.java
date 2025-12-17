package com.workpro.mytaxitravel.Entity;

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
    private int idViaje;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_conductor", nullable = false)
    private Conductor idConductor;

    @Column(name = "estado_viaje", nullable = false)
    private boolean estadoViaje;
    @Column(name = "costo_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal costoFinal;
    @Column(name = "tipo_pago", nullable = false, length = 60)
    private String tipoPago;

    @OneToOne
    @JoinColumn(name = "calificacion_final")
    private Calificacion calificacionFinal;

    @OneToOne
    @JoinColumn(name = "registro_GPS")
    private RegistroGPS registroGPS;

}
