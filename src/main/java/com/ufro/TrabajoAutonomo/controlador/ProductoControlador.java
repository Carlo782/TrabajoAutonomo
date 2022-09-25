package com.ufro.TrabajoAutonomo.controlador;

import com.ufro.TrabajoAutonomo.entidad.Producto;
import com.ufro.TrabajoAutonomo.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;



    @GetMapping("/listar")
    public String listar(Model modelo){
        List<Producto> productos=servicio.listarProducto();
        modelo.addAttribute("productos", productos);
    return "Inicio_Principal";
    }



}
