package com.ufro.TrabajoAutonomo.repositorio;


import com.ufro.TrabajoAutonomo.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductoRepositorio extiende de JpaReoository, lo que otorga muchos metodos necesarios para el proyecto
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
