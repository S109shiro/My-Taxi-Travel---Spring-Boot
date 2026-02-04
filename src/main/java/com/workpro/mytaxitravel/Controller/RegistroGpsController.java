package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.Entity.RegistroGPS;
import com.workpro.mytaxitravel.Service.RegistroGPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/registroGPS")
public class RegistroGpsController {
    @Autowired
    RegistroGPSService registroGPSService;

    @GetMapping("/get/{id_registroGPS}")
    public Optional<RegistroGPS> getRegistroGPS(@PathVariable("id_registroGPS") int idRegistroGPS){
        return registroGPSService.getRegistroGPS(idRegistroGPS);
    }

    @PostMapping("/create")
    public String createRegistroGPS(@RequestBody RegistroGPS nuevoRegistroGPS){
        registroGPSService.saveRegistroGPS(nuevoRegistroGPS);
        return "Registro GPS registrado con el siguiente id: " + nuevoRegistroGPS.getIdRegistroViaje();
    }

    @PutMapping("/update")
    public String updateRegistroGPS(@RequestBody RegistroGPS registroGPS){
        registroGPSService.updateRegistroGPS(registroGPS);
        return "El registro GPS con el id: " + registroGPS.getIdRegistroViaje() + " ha sido modificado.";
    }

    @DeleteMapping("/delete/{id_registroGPS}")
    public String deleteRegistroGPS(@PathVariable("id_registroGPS") int idRegistroGPS){
        registroGPSService.deleteRegistroGPS(idRegistroGPS);
        return "El registro GPS con el id: " + idRegistroGPS + " ha sido eliminado.";
    }


}
