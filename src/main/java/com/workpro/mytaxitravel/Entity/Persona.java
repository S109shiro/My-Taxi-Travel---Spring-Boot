package com.workpro.mytaxitravel.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.sql.Date;

// Me permite tener una super clase para heredar
@MappedSuperclass
public abstract class Persona {
    private String nombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    private int edad;
    @Column(name = "numero_identificacion")
    private int numeroIdentificacion;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private String sexo;
    @Column(name = "documento_identidad")
    private String documentoIdentidad;
    @Column(name = "numero_telefono")
    private String telefono;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String contrasena;
}
