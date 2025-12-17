package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Taxi;
import com.workpro.mytaxitravel.Repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxiService {
    @Autowired
    private TaxiRepository taxiRepository;

    public List<Taxi> getTaxis(){
        return taxiRepository.findAll();
    }

    public Optional<Taxi> getTaxi(int id){
        return taxiRepository.findById(id);
    }

    public void saveOrUpdateTaxi(Taxi taxi){
        taxiRepository.save(taxi);
    }

    public void deleteTaxi(int id){
        taxiRepository.deleteById(id);
    }

}
