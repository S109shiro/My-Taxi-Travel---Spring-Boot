package com.workpro.mytaxitravel.Service;

import com.workpro.mytaxitravel.Entity.Usuario;
import com.workpro.mytaxitravel.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// Decimos que es un service va la logica de negocio
@Service
public class UsuarioService {
    // Utilizamos el autowired para
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

    // Guardar o actualizar un nuevo usuario
    public void saveOrUpdateUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    // Eliminar un usuario
    public void deleteUsuario(int id){
        usuarioRepository.deleteById(id);
    }
}
