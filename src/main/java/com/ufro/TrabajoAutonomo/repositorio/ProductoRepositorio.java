package com.ufro.TrabajoAutonomo.repositorio;


import com.ufro.TrabajoAutonomo.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
