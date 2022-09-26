package com.ufro.TrabajoAutonomo.servicio;
/**
 * En ProductoServicio se guardarán todos los metodos necesarios que serán usados posteriormente en las clases de Controlador
 */

import com.ufro.TrabajoAutonomo.entidad.Producto;
import com.ufro.TrabajoAutonomo.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio repositorio;


    /**
     * El metodo listarProducto permite mostrar los registros que se encuentren en la base de datos utilizando el metodo findAll que se encuentra en productoRepositorio
     * gracias que este extiende de jpaRepository
     * @return Retorna todos los registros de una tabla de la base de datos
     */
    public List<Producto> listarProducto(){
        return repositorio.findAll();
    }


    /**
     * El metodo guarda un producto que se le entrega por parametro con el metodo save, este se encuentra en productoRepositorio gracias a que este extiende
     * de JpaRepository
     * @param producto Produco que se guardará
     */
    public void crearNuevoProducto(Producto producto){
        repositorio.save(producto);
    }

    /**
     * El metodo obtiene un registro especifico de la base de datos basandose por el id que se le entrega por parametros y esto lo hace utilizando el metodo
     * findById que se encuentra en el productoRepositorio gracias a que este extiende de JpaRepository
     * @param id id del producto que se quiere obtener
     * @return Retorna el producto que se encontró con el id corresponiende al dado por parametros
     */
    public Producto obtenerProductoPorId(Long id){
    return repositorio.findById(id).get();
    }

    /**
     * El metodo guarda un producto despues de editarlo con el metodo save, este se encuentra en productoRepositorio gracias a que este extiende
     * de JpaRepository
     * @param producto Producto que se quiere guardar despues de editar
     */
    public void actualizarProducto(Producto producto){
         repositorio.save(producto);

    }

    /**
     * El metodo eliminar producto elimina un registro de la base de datos que cuente con el mismo id que el que se entrega por parametros
     * utiliza el metodo deleteById que se encuentra en productoRepositorio gracias a que este extiende de JpaRepository
     * @param id Id del producto que se quiere eliminar
     */
    public void elminiarProducto(Long id){
        repositorio.deleteById(id);



    }



}
