package com.workpro.mytaxitravel.Repository;

import com.workpro.mytaxitravel.Entity.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {

}
