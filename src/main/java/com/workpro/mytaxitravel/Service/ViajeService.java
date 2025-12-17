package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Viaje;
import com.workpro.mytaxitravel.Repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViajeService {
    @Autowired
    ViajeRepository viajeRepository;

    public Optional<Viaje> getViaje(int id){
        return viajeRepository.findById(id);
    }

    public void saveOrUpdateViaje(Viaje viaje){
        viajeRepository.save(viaje);
    }


}
