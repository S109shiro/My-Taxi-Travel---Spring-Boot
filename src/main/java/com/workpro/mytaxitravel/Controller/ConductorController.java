package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.Entity.Conductor;
import com.workpro.mytaxitravel.Repository.ConductorRepository;
import com.workpro.mytaxitravel.Service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/conductor")
public class ConductorController {
    // Instancia de service del conductor
    @Autowired
    ConductorService conductorService;
    //ConductorRepository conductorRepository;

    @GetMapping("/getAll")
    public List<Conductor> getConductores(){
        return conductorService.getConductores();
    }

    @GetMapping("/get/{id_conductor}")
    public Optional<Conductor> getConductor(@PathVariable("id_conductor") int idConductor){
        return conductorService.getConductor(idConductor);
    }

    @PostMapping("/create")
    public String saveConductor(@RequestBody Conductor nuevoConductor){
        conductorService.saveConductor(nuevoConductor);
        return "Conductor registrado con el siguiente id: " + nuevoConductor.getIdConductor();
    }

    @PutMapping("/update")
    public String updateConductor(@RequestBody Conductor conductor){
        conductorService.updateConductor(conductor);
        return "El conductor con el id: " + conductor.getIdConductor() + " ha sido modificado.";
    }

    @DeleteMapping("/delete/{id_conductor}")
    public String deleteConductor(@PathVariable("id_conductor") int idConductor){
        conductorService.deleteConductor(idConductor);
        return "El conductor con el id: " + idConductor + " ha sido eliminado.";
    }

}
