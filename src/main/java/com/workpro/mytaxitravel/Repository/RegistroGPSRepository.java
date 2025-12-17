package com.workpro.mytaxitravel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workpro.mytaxitravel.Entity.RegistroGPS;

@Repository
public interface RegistroGPSRepository extends JpaRepository<RegistroGPS, Integer> {

}
