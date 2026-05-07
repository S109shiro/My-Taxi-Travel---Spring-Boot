package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.DTO.DTOLogin;
import com.workpro.mytaxitravel.Entity.Usuario;
import com.workpro.mytaxitravel.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


// Decimos que es un service va la logica de negocio
@Service
public class UsuarioService {
    // Utilizamos el autowired para inyectar dependencias
    @Autowired
    UsuarioRepository usuarioRepository;

    // Metodo para obtener una lista de todos los usuarios
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    // Optional porque no sabemos si retorna algo
    public Optional<Usuario> getUsuario(int id){
        return usuarioRepository.findById(id);
    }

    // Guardar un nuevo usuario
    public String saveUsuario(Usuario usuario){
        try{
            usuarioRepository.save(usuario);
            return "Usuario registrado con el siguiente id: " + usuario.getIdUsuario();

        }catch (Exception e){
            return e.getMessage().substring(0, e.getMessage().indexOf("] ")+1);
        }
    }

    // Actualizar usuario
    public String updateUsuario(Usuario usuario){
        try{
            usuarioRepository.save(usuario);
            return "El usuario con el id: " + usuario.getIdUsuario() + " ha sido actualizado";
        } catch (ObjectOptimisticLockingFailureException e) {
            return e.getMessage();
        }catch (DataIntegrityViolationException d){
            return d.getMessage().substring(0, d.getMessage().indexOf("] ")+1);
        }
    }

    // Eliminar un usuario
    public boolean deleteUsuario(int id){
        if(getUsuario(id).isPresent()){
            usuarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    // Loguear un usuario
    public Usuario loginUsuario(DTOLogin DatosLogin){
        return usuarioRepository.findByEmail(DatosLogin.getEmail());
    }
}
