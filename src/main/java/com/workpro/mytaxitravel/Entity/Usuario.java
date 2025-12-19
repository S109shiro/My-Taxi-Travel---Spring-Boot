package com.workpro.mytaxitravel.Entity;
// Lombok nos ayuda a no tener que hacer codigo repetitivo // getters and setters
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id_usuario")
    @Column(name = "id_usuario")
    private int idUsuario;

    @JsonProperty("calificacion_media")
    @Column(name = "calificacion_media", nullable = false)
    private double clasificacionMedia;

}
