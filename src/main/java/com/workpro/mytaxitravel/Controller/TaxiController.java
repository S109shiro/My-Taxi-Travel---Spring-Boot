package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.Entity.Taxi;
import com.workpro.mytaxitravel.Service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taxi")
public class TaxiController {
    @Autowired
    TaxiService taxiService;

    @GetMapping("/getAll")
    public List<Taxi> getTaxis(){
        return taxiService.getTaxis();
    }

    @GetMapping("/get/{id_taxi}")
    public Optional<Taxi> getTaxi(@PathVariable("id_taxi") int id_taxi){
        return taxiService.getTaxi(id_taxi);
    }

    @PostMapping("/create")
    public String createTaxi(@RequestBody Taxi nuevoTaxi){
        taxiService.saveTaxi(nuevoTaxi);
        return "Taxi registrado con el siguiente id: " + nuevoTaxi.getIdTaxi();
    }

    @PutMapping("/update")
    public String updateTaxi(@RequestBody Taxi taxi){
        taxiService.updateTaxi(taxi);
        return "El taxi con el id: " + taxi.getIdTaxi() + " ha sido modificado.";
    }

    @DeleteMapping("/delete/{id_taxi}")
    public String deleteTaxi(@PathVariable("id_taxi") int id_taxi){
        taxiService.deleteTaxi(id_taxi);
        return "El taxi con el id: " + id_taxi + " ha sido eliminado.";
    }

}
