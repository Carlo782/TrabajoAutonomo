package com.ufro.TrabajoAutonomo.repositorio;

import com.ufro.TrabajoAutonomo.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepositorio extiende de JpaReoository, lo que otorga muchos metodos necesarios para el proyecto
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
