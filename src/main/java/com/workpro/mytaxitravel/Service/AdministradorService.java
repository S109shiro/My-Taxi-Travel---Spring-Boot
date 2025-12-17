package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Administrador;
import com.workpro.mytaxitravel.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Indicamos que es un service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    // Obtener todos los administradores
    public List<Administrador> getAdministradores(){
        return administradorRepository.findAll();
    }

    // Obtener por id un administrador (Opcional por si no lo encuentra, puede existir o no, vacio o lleno)
    public Optional<Administrador> getAdministrador(int id){
        return administradorRepository.findById(id);
    }

    // Guardar o actualizar un objeto administrador
    public void saveOrUpdateAdministrador(Administrador administrador){
        administradorRepository.save(administrador);
    }

}
