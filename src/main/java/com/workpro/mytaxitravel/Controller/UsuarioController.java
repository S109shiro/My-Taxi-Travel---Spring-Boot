package com.workpro.mytaxitravel.Controller;


import com.workpro.mytaxitravel.Entity.Persona;
import com.workpro.mytaxitravel.Entity.Usuario;
import com.workpro.mytaxitravel.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController  // Indica que esta clase es un rest controller el cual permite
// Manejar solicitudes http - Devuelve objetos como Json o xml - Es un endpoint
@RequestMapping(path = "/usuarios")  // Indica la url del controlador a utilizar
public class UsuarioController {
    @Autowired  //
    private UsuarioService usuarioService;  // Traemos los servicios para aplicar los metodos de la logica de negocio

    /*@GetMapping(path = "/getUsuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();  // LLamamos al service
    }*/

    @GetMapping(path = "/getUsuario/{id_usuario}")
    public Optional<Usuario> getUsuario(@PathVariable("id_usuario") int idUsuario){  // Path es para obtener una variable de la url
        return usuarioService.getUsuario(idUsuario);
    }

    @PostMapping(path = "/createUsuario")
    public String createUsuario(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "Usuario registrado con el Id: " + usuario.getIdUsuario();
    }

    @PutMapping(path = "/updateUsuario")
    public String updateUsuario(@RequestBody Usuario usuario){
        usuarioService.updateUsuario(usuario);
        return "El usuario: " + usuario.getNombre() + " ha sido actualizado";
    }

    @DeleteMapping(path = "/deleteUsuario/{id_usuario}")
    public String deleteUsuario(@PathVariable("id_usuario") int id){
        usuarioService.deleteUsuario(id);
        return "El usuario con el id: " + id + " ha sido eliminado";
    }
}
