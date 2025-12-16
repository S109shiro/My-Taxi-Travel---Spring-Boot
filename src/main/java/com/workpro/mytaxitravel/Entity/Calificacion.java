package com.workpro.mytaxitravel.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

@Data
@Entity
@Table(name = "tb_calificacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private int idCalificacion;

    @DecimalMin("0.0")
    @DecimalMax("5.0")
    @Column(name = "calificacion_usuario", precision = 3, scale = 2, nullable = false)
    private BigDecimal calificacionUsuario;

    @DecimalMin("0.0")
    @DecimalMax("5.0")
    @Column(name = "calificacion_conductor", precision = 3, scale = 2, nullable = false)
    private BigDecimal calificacionConductor;

    @Column(name = "comentario_usuario")
    private String comentarioUsuario;
    @Column(name = "comentario_conductor")
    private String comentarioConductor;
    
}
