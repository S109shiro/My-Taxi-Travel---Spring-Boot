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
@Table(name = "tb_reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private int idReporte;
    @Column(name = "fecha_reporte", nullable = false)
    private Date fechaReporte;
    @Column(name = "tipo_reporte", nullable = false, length = 20)
    private String tipoReporte;
    @Column(nullable = false)
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "encargado_reporte", nullable = false)
    private Administrador encargado_reporte;

}
