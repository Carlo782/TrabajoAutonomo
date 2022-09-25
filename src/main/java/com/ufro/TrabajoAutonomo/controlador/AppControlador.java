package com.ufro.TrabajoAutonomo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppControlador {


    @GetMapping("/inicioSesion")
    public String inicioSesion(){

        return "Inicio_Sesion";
    }


    @GetMapping("/inicio")
        public String inicio(){

           return "redirect:/listar";
        }



}
