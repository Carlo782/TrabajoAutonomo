package com.ufro.TrabajoAutonomo.controlador;

/**
 * ProductoControlador va a  contener todos las url de vistas y metodos que estén relacionadas a Producto..
 */


import com.ufro.TrabajoAutonomo.entidad.Producto;
import com.ufro.TrabajoAutonomo.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;


    /**
     *  El metodo listar permite que se puedan listar todos los registros que estén almacenados en la base de datos
     * @param modelo Se asigna un modelo para que pueda usar el addAtribute para que se pueda usar Producto y sus atributos en el html
     * @return retorna el inicio de la aplicacion con los productos de la base de datos listados
     */
    @GetMapping("/listar")
    public String listar(Model modelo){
        List<Producto> productos=servicio.listarProducto();
        modelo.addAttribute("productos", productos);
    return "Inicio_Principal";

    }

    /**
     *  El metodo crear permite que se pueda mostrar el formulario para crear un nuevo producto asi como permitir que se puedan usar
     *  los atributos y metodos de Persona en el html
     *
     * @param modelo Se asigna un modelo para que pueda usar el addAtribute para que permita utilizar  Producto y sus atributos en los html
     *
     * @return Retorna el formulario para poder registrar un nuevo producto
     */
    @GetMapping("/nuevoProducto")
    public String crear(Model modelo){
    modelo.addAttribute("productos",new Producto());
        return "Form_Producto_Crear";
    }

    /**
     *  El metodo guardar permite crear un nuevo registro en la base de datos con los datos obtenidos del formulario
     * @param p Se le pasa un Producto que es el que se va a guardar en la base de datos
     * @return Una vez finalizado se redirecciona a inicio lo que muestra la pagina principal del proyecto con el listado de productos
     */
    @PostMapping("/agregar")
    public String guardar( Producto p){
        servicio.crearNuevoProducto(p);
        return "redirect:/inicio";
    }

    /**
     *  El metodo mostrarFormularioDeEditar muestra un formulario con los datos del producto ya seleccionado para hacer posible la edición de los datos
     * @param id Se le debe entregar el id para que se pueda buscar el producto por Id y se pueda modificar el producto correcto
     * @param modelo se asigna un modelo para poder utilizar el addAtribute para que el foro de editar producto pueda utilizar Producto y sus metodos
     * @return Retorna el foro donde se realizará la edicion del producto seleccionado
     */
   @GetMapping("/inicio/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
        modelo.addAttribute("producto",servicio.obtenerProductoPorId(id));
    return "Form_Producto_Editar";
   }

    /**
     *  El metodo actualizar producto realiza una actualizacion del producto de acuerdo a los cambios que hayamos realizado en el foro para editarlo
     * @param id Se le pasa un Id para que se actualizarse el producto coresponiente al id
     * @param producto Se le pasa un nuevo Porudcto que contendrá los nuevos datos para actualizar el producto exitente
     * @return Redirreciona a inicio donde se muetra la pagina principal del proyecto y los productos guardados en la base de datos listados
     */
   @PostMapping("/editar/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute ("producto") Producto producto){
    Producto productoExistente= servicio.obtenerProductoPorId(id);

    productoExistente.setId(id);
    productoExistente.setNombre(producto.getNombre());
    productoExistente.setDescripcion(producto.getDescripcion());
    productoExistente.setCantidad(producto.getCantidad());
    productoExistente.setCategoria(producto.getCategoria());

    servicio.actualizarProducto(productoExistente);
    return "redirect:/inicio";
   }

    /**
     * El metodo eliminar nos premite borrar un registro de Producto que esté en la base de datos con la id
     * que se entrega por parametros
     * @param id Id del producto a eliminar
     * @return Redirige al inicio donde se encuentra la pagina principal del proyecto y los productos listados
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id){
        servicio.elminiarProducto(id);
        return "redirect:/inicio";
    }






}
