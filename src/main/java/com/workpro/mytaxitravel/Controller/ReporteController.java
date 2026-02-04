package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.Entity.Reporte;
import com.workpro.mytaxitravel.Service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reporte")
public class ReporteController {
    @Autowired
    ReporteService reporteService;

    @GetMapping("/getAll")
    public List<Reporte> getReportes(){
        return reporteService.getReportes();
    }

    @GetMapping("/get/{id_reporte}")
    public Optional<Reporte> getReporte(@PathVariable("id_reporte") int id_reporte){
        return reporteService.getReporte(id_reporte);
    }

    @PostMapping("/create")
    public String createReporte(@RequestBody Reporte nuevoReporte){
        reporteService.saveReporte(nuevoReporte);
        return "Reporte registrado con el siguiente id: " + nuevoReporte.getIdReporte();
    }

    @PutMapping("/update")
    public String updateReporte(@RequestBody Reporte reporte){
        reporteService.updateReporte(reporte);
        return "El registro con el id: " + reporte.getIdReporte() + " ha sido modificado.";
    }

    @DeleteMapping("/delete/{id_reporte}")
    public String deleteReporte(@PathVariable("id_reporte") int id_reporte){
        reporteService.deleteReporte(id_reporte);
        return "El reporte con el id: " + id_reporte + " ha sido eliminado.";
    }



}
