package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.Entity.Administrador;
import com.workpro.mytaxitravel.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @GetMapping(path = "/getAll")
    public List<Administrador> getAdministradores(){
        return administradorService.getAdministradores();
    }

    @GetMapping(path = "/get/{id_administrador}")
    public Optional<Administrador> getAdministrador(@PathVariable("id_administrador") int id_administrador){
        return administradorService.getAdministrador(id_administrador);
    }

    @PostMapping(path = "/create")
    public String createAdministrador(@RequestBody Administrador nuevoAdministrador){
        administradorService.saveAdministrador(nuevoAdministrador);
        return "Administrador registrado con el siguiente id: " + nuevoAdministrador.getIdAdministrador();
    }

    @PutMapping(path = "/update")
    public String updateAdministrador(@RequestBody Administrador administrador){
        administradorService.updateAdministrador(administrador);
        return "El administrador con el id: " + administrador.getIdAdministrador() + " ha sido modificado.";
    }

    @DeleteMapping(path = "/delete/{id_administrador}")
    public String deleteAdministrador(@PathVariable("id_administrador") int id_administrador){
        administradorService.deleteAdministrador(id_administrador);
        return "El administrador con el id: " + id_administrador + " ha sido eliminado.";
    }


}
