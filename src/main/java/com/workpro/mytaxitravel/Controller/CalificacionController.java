package com.workpro.mytaxitravel.Controller;


import com.workpro.mytaxitravel.Entity.Calificacion;
import com.workpro.mytaxitravel.Service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {
    @Autowired
    CalificacionService calificacionService;

    @GetMapping("/get/{id_calificacion}")
    public Optional<Calificacion> getCalificacion(@PathVariable("id_calificacion") int id_calificacion){
        return calificacionService.getCalificacion(id_calificacion);
    }

    @PostMapping("/create")
    public String createCalificacion(@RequestBody Calificacion nuevaCalificacion){
        calificacionService.saveCalificacion(nuevaCalificacion);
        return "Calificacion registrada con el siguiente id: " + nuevaCalificacion.getIdCalificacion();
    }

    @PutMapping("/update")
    public String updateCalificacion(@RequestBody Calificacion calificacion){
        calificacionService.updateCalificacion(calificacion);
        return "La calificacion con el id: " + calificacion.getIdCalificacion() + " ha sido modificado.";
    }

    @DeleteMapping("/delete/{id_calificacion}")
    public String deleteCalificacion(@PathVariable("id_calificacion") int id_calificacion){
        calificacionService.deleteCalificacion(id_calificacion);
        return "La calificacion con el id: " + id_calificacion + " ha sido eliminada.";
    }
}
