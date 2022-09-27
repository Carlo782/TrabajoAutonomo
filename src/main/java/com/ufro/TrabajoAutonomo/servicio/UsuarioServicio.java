package com.ufro.TrabajoAutonomo.servicio;

import com.ufro.TrabajoAutonomo.entidad.Usuario;
import com.ufro.TrabajoAutonomo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio repositorio;

    /**
     * El metodo listarUsuarios permite mostrar los registros que se encuentren en la base de datos utilizando el metodo findAll que se encuentra en UsuarioRepositorio
     * gracias que este extiende de jpaRepository
     * @return
     */
    public List<Usuario> listarUsuarios(){
        return repositorio.findAll();
    }

    /**
     * El metodo crearNuevoUsuario guarda un nuevo usuario
     * @param usuario Le pasamos por parametro el usuario que queramos guardar
     */
    public void crearNuevoUsuario(Usuario usuario){

        repositorio.save(usuario);
    }

    /**
     * Este metodo permite enconrar un usuario especifico por su id
     * @param id Le pasamos el id del usuario que queramos encontrar
     * @return Nos regresa el usuario de la id correspondiente
     */
    public Usuario obtenerUsuarioPorId(Long id){
        return repositorio.findById(id).get();
    }

    /**
     * Este metodo elimina un usuario que esté guardado
     * @param id le pasamos el id del usuario que queramos eliminar
     */
    public void eliminarUsuario(Long id){
        repositorio.deleteById(id);
    }





}
