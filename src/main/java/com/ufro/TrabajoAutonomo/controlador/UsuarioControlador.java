package com.ufro.TrabajoAutonomo.controlador;
/**
 * UsuarioControlador va a contener todas los url, vistas  metodos donde se utilice usuario
 */

import com.ufro.TrabajoAutonomo.entidad.Usuario;
import com.ufro.TrabajoAutonomo.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioServicio servicio;


    /**
     * Muestra todos los usuarios que estén en su en la tabla usuarios en la base de datos
     * @param modelo se asigna un modelo para que pueda usar el addAtribute para que se pueda usar Usuario y sus atributos en el html
     * @return Retorna la vista de html de Lista_Usuarios
     */
    @GetMapping("/listar/usuarios")
    public String listarUsuarios(Model modelo){
        List<Usuario> usuario=servicio.listarUsuarios();
        modelo.addAttribute("usuarios",usuario);
        return "Lista_Usuarios";
    }


    /**
     *  Ingresa al formulario donde se crearán los usuarios
     * @param modelo Se entrega un modelo para que pueda usar el addAtribute para que se pueda usar Usuario y sus atributos en el html
     *               y así poder crear un nuevo usuario
     * @return Retorna el formulario donde se crearán los usuarios
     */

    @GetMapping("/crearUsuario")
    public String ingresoFormularioUsuario(Model modelo){
        modelo.addAttribute("usuario",new Usuario());
        return "Form_Producto_Usuario";

    }

    /**
     * Guarda los usuarios creados en el formulario
     * @param usuario Se entrega el usuario que se quiere guardar
     *
     * @return Redirige a listar/usuarios donde está el listado de todos los usuarios en la base de datos
     */
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario){
        servicio.crearNuevoUsuario(usuario);
        return "redirect:/listar/usuarios";
    }


    /**
     * elimina un usuario deacuerdo a la id
     * @param id se pasa el id por parametro del usuario que se quiere eliminar
     *
     * @return redirecciona a donde se encuentra el listado de todos los usuarios de la base de datos
     */

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        servicio.eliminarUsuario(id);
        return "redirect:/listar/usuarios";
    }


}
