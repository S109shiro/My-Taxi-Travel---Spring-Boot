package com.workpro.mytaxitravel.Controller;


import com.workpro.mytaxitravel.Entity.Usuario;
import com.workpro.mytaxitravel.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // Indica que esta clase es un rest controller el cual permite
// Manejar solicitudes http - Devuelve objetos como Json o xml - Es un endpoint
@RequestMapping(path = "/usuario")  // Indica la url del controlador a utilizar

public class UsuarioController {
    @Autowired  //
    private UsuarioService usuarioService;  // Traemos los servicios para aplicar los metodos de la logica de negocio

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> users = usuarioService.getUsuarios();
        if(users.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
        }else{
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping(path = "/get/{id_usuario}")
    public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable("id_usuario") int idUsuario){  // Path es para obtener una variable de la url
        Optional<Usuario> user = usuarioService.getUsuario(idUsuario);
        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }else{
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createUsuario(@RequestBody Usuario nuevoUsuario){
        usuarioService.saveUsuario(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con el siguiente id: " + nuevoUsuario.getIdUsuario());
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateUsuario(@RequestBody Usuario usuario){
        boolean exception = usuarioService.updateUsuario(usuario);
        if(exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el id: " + usuario.getIdUsuario() + " no existe en la base de datos.");
        }else {
            return ResponseEntity.ok("El usuario con el id: " + usuario.getIdUsuario() + " ha sido actualizado");
        }
    }

    @DeleteMapping(path = "/delete/{id_usuario}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id_usuario") int idUsuario){
        boolean idExist = usuarioService.deleteUsuario(idUsuario);
        if(idExist){
            return ResponseEntity.ok("El usuario con el id: " + idUsuario + " ha sido eliminado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el id: " + idUsuario + " no existe en la base de datos");
        }
    }
}
