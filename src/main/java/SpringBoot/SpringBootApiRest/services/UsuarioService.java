package SpringBoot.SpringBootApiRest.services;


import SpringBoot.SpringBootApiRest.DTOs.UsuarioRequestDTO;
import SpringBoot.SpringBootApiRest.models.EstadoModel;
import SpringBoot.SpringBootApiRest.models.PaisModel;
import SpringBoot.SpringBootApiRest.models.UsuarioModel;
import SpringBoot.SpringBootApiRest.repositories.IEstadoRepository;
import SpringBoot.SpringBootApiRest.repositories.IPaisRepository;
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
    @Autowired
    IPaisRepository iPaisRepository;
    @Autowired
    IEstadoRepository iEstadoRepository;


    // Obtener todos los usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios(){
       return (ArrayList<UsuarioModel>)  usuarioRepository.findAll();
    }

    // set guardar un usuario nuevo
    public UsuarioModel agregarUsuario(UsuarioRequestDTO usuarioDTO){
        UsuarioModel usuarioNuevo = new UsuarioModel();
        usuarioNuevo.setNombre(usuarioDTO.getNombre());
        usuarioNuevo.setApellido(usuarioDTO.getApellido());
        usuarioNuevo.setEdad(usuarioDTO.getEdad());
        usuarioNuevo.setEmail(usuarioDTO.getEmail());

        // buscamos el pais por el id
        PaisModel pais = this.iPaisRepository.findById(usuarioDTO.getPaisId()).orElseThrow();
        usuarioNuevo.setPais(pais);

        // buscamos el estado por el Id
        EstadoModel estado = this.iEstadoRepository.findById(usuarioDTO.getEstadoId()).orElseThrow();
        usuarioNuevo.setEstado(estado);

;        return this.usuarioRepository.save(usuarioNuevo);
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
