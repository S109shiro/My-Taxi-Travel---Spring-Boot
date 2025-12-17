package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Conductor;
import com.workpro.mytaxitravel.Repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorService {
    @Autowired   // Inyeccion de dependencias
    ConductorRepository conductorRepository;  // Instance una variable con la interface

    public List<Conductor> getConductores(){
        return conductorRepository.findAll();
    }

    public Optional<Conductor> getConductor(int id){
        return conductorRepository.findById(id);
    }

    public void saveOrUpdateConductor(Conductor conductor){
        conductorRepository.save(conductor);
    }

    public void deleteConductor(int id){
        conductorRepository.deleteById(id);
    }
}
