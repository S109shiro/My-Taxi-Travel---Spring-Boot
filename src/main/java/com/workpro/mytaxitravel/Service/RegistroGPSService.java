package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.RegistroGPS;
import com.workpro.mytaxitravel.Repository.RegistroGPSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroGPSService {
    @Autowired
    private RegistroGPSRepository registroGPSRepository;

    public Optional<RegistroGPS> getRegistroGPS(int id){
        return registroGPSRepository.findById(id);
    }

    public void saveOrUpdateRegistroGPS(RegistroGPS registroGPS){
        registroGPSRepository.save(registroGPS);
    }



}
