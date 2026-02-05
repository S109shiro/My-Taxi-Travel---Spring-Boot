package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.Entity.Viaje;
import com.workpro.mytaxitravel.Service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/viaje")
@RestController
public class ViajeController {
    @Autowired
    ViajeService viajeService;

    @GetMapping("/getAll")
    public List<Viaje> getViajes(){
        return  viajeService.getViajes();
    }

    @GetMapping("/get/{id_viaje}")
    public Optional<Viaje> getViaje(@PathVariable("id_viaje") int id_viaje){
        return viajeService.getViaje(id_viaje);
    }

    @PostMapping("/create")
    public String createViaje(@RequestBody Viaje nuevoViaje){
        viajeService.saveViaje(nuevoViaje);
        return "Viaje registrado con el siguiente id: " + nuevoViaje.getIdViaje();
    }

    @PutMapping("/update")
    public String updateViaje(@RequestBody Viaje viaje){
        viajeService.updateViaje(viaje);
        return "El viaje con el id: " + viaje.getIdViaje() + " ha sido actualizado";
    }

    @DeleteMapping("/delete/{id_viaje}")
    public String deleteViaje(@PathVariable("id_viaje") int id_viaje){
        viajeService.deleteViaje(id_viaje);
        return "El viaje con el id: " + id_viaje + " ha sido eliminado";
    }

}
