package com.workpro.mytaxitravel.Repository;

import com.workpro.mytaxitravel.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Creamos una interface donde extendemos de la clase jpa repository e indicamos la entidad y el valor primario a trabajar
@Repository  // Indicamos que es un repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Esta interface repositorio tiene los metodos para acceder a los datos de la bd
}
