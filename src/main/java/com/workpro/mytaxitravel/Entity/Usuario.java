package com.workpro.mytaxitravel.Entity;
// Lombok nos ayuda a no tener que hacer codigo repetitivo // getters and setters
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "calificacion_media", nullable = false)
    private double clasificacionMedia;

}
