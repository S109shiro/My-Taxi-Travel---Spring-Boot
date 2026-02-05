package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Viaje;
import com.workpro.mytaxitravel.Repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {
    @Autowired
    // Obtenemos una instancia del repositorio de viaje
    ViajeRepository viajeRepository;

    // Ver todos los viajes
    public List<Viaje> getViajes(){
        return viajeRepository.findAll();
    }

    // Obtener informacion de un viaje en especifico con el id
    public Optional<Viaje> getViaje(int id){
        return viajeRepository.findById(id);
    }

    public void updateViaje(Viaje viaje){
        viajeRepository.save(viaje);
    }

    public void saveViaje(Viaje viaje){
        viajeRepository.save(viaje);
    }

    public void deleteViaje(int id){
        viajeRepository.deleteById(id);
    }


}
