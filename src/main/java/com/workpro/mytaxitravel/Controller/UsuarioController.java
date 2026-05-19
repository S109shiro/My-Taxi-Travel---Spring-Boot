package com.workpro.mytaxitravel.Controller;

import com.workpro.mytaxitravel.DTO.DTOLogin;
import com.workpro.mytaxitravel.Entity.Usuario;
import com.workpro.mytaxitravel.Security.JwtUtil;
import com.workpro.mytaxitravel.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController  // Indica que esta clase es un rest controller el cual permite
// Manejar solicitudes http - Devuelve objetos como Json o xml - Es un endpoint
@RequestMapping(path = "/usuario")  // Indica la url del controlador a utilizar
public class UsuarioController {
    @Autowired  //
    private UsuarioService usuarioService;  // Traemos los servicios para aplicar los metodos de la logica de negocio

    @Autowired
    private JwtUtil jwtUtil;

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
        if(usuarioService.saveUsuario(nuevoUsuario).equals("Usuario registrado con el siguiente id: " + nuevoUsuario.getIdUsuario())){
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(nuevoUsuario));
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuarioService.saveUsuario(nuevoUsuario));
        }
    }
    // Personalizar salidas
    @PutMapping(path = "/update")
    public ResponseEntity<String> updateUsuario(@RequestBody Usuario usuario){
        String result = usuarioService.updateUsuario(usuario);
        if(result.equals("El usuario con el id: " + usuario.getIdUsuario() + " ha sido actualizado")){
            return ResponseEntity.ok(result);
        }else if(result.startsWith("Row")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el id: " + usuario.getIdUsuario() + " no existe en la base de datos.");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
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

    @PostMapping(path = "/login")
    public ResponseEntity<Map<String, String>> loginUsuario(@RequestBody DTOLogin DatosLogin){
        Usuario usuarioExist = usuarioService.loginUsuario(DatosLogin);
        if(usuarioExist == null || !(usuarioExist.getContrasena().equals(DatosLogin.getContrasena()))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }else{
            // Obtencion de datos importantes para el login y apartados de la cuenta
            String token = jwtUtil.generarToken(usuarioExist.getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("nombreUsuario", usuarioExist.getNombre());
            response.put("idUser", String.valueOf(usuarioExist.getIdUsuario()));
            return ResponseEntity.ok(response);
        }
    }
}
