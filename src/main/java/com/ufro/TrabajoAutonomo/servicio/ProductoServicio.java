package com.ufro.TrabajoAutonomo.servicio;


import com.ufro.TrabajoAutonomo.entidad.Producto;
import com.ufro.TrabajoAutonomo.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio repositorio;


    public List<Producto> listarProducto(){
        return repositorio.findAll();
    }



    public void crearNuevoProducto(Producto producto){
        repositorio.save(producto);
    }


}
