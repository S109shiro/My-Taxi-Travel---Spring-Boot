package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Calificacion;
import com.workpro.mytaxitravel.Repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    public Optional<Calificacion> getCalificacion(int id){
        return calificacionRepository.findById(id);
    }

    public void saveOrUpdate(Calificacion calificacion){
        calificacionRepository.save(calificacion);
    }
}
