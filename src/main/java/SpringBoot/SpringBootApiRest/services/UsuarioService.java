package SpringBoot.SpringBootApiRest.services;


import SpringBoot.SpringBootApiRest.models.UsuarioModel;
import SpringBoot.SpringBootApiRest.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    // se realiza una inyeccion de dependencias automaticamente
    IUsuarioRepository usuarioRepository;


    // Obtener todos los usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios(){
       return (ArrayList<UsuarioModel>)  usuarioRepository.findAll();
    }

    // set guardar un usuario nuevo
    public UsuarioModel agregarUsuario(UsuarioModel usuario){
        return this.usuarioRepository.save(usuario);
    }
    // getById
    public Optional<UsuarioModel> obtenerPorId(long id){
        return usuarioRepository.findById(id);
    }

    // getByEstado
    public Optional<ArrayList<UsuarioModel>>obtenerPorEstado(long id){
        return usuarioRepository.findByEstadoId(id);
    }
    // getbyPais
    public ArrayList<UsuarioModel>obtenerPorPais(long idPais){
        return usuarioRepository.findByPaisId(idPais);
    }

    // delete
    public boolean eliminarUsuario(long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }



}
