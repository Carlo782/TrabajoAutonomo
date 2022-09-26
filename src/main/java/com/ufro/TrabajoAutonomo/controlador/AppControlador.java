package com.ufro.TrabajoAutonomo.controlador;

/**
 * AppControlador será donde se contendrán los metodos que ayuden a desplazarse por las ventanas que no necesiten relizar una accion.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppControlador {

    /**
     * El metodo inicio se utiliza para ir a la pagina principal del programa
     * @return una vez introducido el url este se redirecciona a listar donde se devuele la pagina de inicio con los productos listados
     */
    @GetMapping({"/inicio","/"})
        public String inicio(){

           return "redirect:/listar";
        }
}
