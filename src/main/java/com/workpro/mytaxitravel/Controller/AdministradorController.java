package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.DTO.DTOLogin;
import com.workpro.mytaxitravel.Entity.Administrador;
import com.workpro.mytaxitravel.Entity.Usuario;
import com.workpro.mytaxitravel.Security.JwtUtil;
import com.workpro.mytaxitravel.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private JwtUtil jwtUtil;

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

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> loginAdministrador(@RequestBody DTOLogin DatosLogin){
        Administrador adminExist = administradorService.loginAdministrador(DatosLogin);
        if(adminExist == null || !(adminExist.getContrasena().equals(DatosLogin.getContrasena()))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }else{
            // Obtencion de datos importantes para el login y apartados de la cuenta
            String token = jwtUtil.generarToken(adminExist.getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("nombreAdministrador", adminExist.getNombre());
            response.put("idAdmin", String.valueOf(adminExist.getIdAdministrador()));
            return ResponseEntity.ok(response);
        }
    }


}
