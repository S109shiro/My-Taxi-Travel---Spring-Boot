package com.workpro.mytaxitravel.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

// Me permite tener una super clase para heredar
@MappedSuperclass
public abstract class Persona {
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "primer_apellido", length = 50, nullable = false)
    private String primerApellido;
    @Column(name = "segundo_apellido", length = 50, nullable = false)
    private String segundoApellido;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "numero_identificacion", unique = true, nullable = false)
    private int numeroIdentificacion;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;
    @Column(name = "documento_identidad", nullable = false)
    private String documentoIdentidad;
    @Column(name = "numero_telefono", length = 10, nullable = false)
    private String telefono;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "contrasena", length = 60, nullable = false)
    private String contrasena;
}
