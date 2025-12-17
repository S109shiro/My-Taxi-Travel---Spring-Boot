package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Reporte;
import com.workpro.mytaxitravel.Repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> getReportes(){
        return reporteRepository.findAll();
    }

    public Optional<Reporte> getReporte(int id){
        return reporteRepository.findById(id);
    }

    public void saveOrUpdateReporte(Reporte reporte){
        reporteRepository.save(reporte);
    }

    public void deleteReporte(int id){
        reporteRepository.deleteById(id);
    }
}
