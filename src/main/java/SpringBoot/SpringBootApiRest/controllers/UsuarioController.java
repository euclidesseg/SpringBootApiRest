package SpringBoot.SpringBootApiRest.controllers;


import SpringBoot.SpringBootApiRest.DTOs.UsuarioRequestDTO;
import SpringBoot.SpringBootApiRest.models.UsuarioModel;
import SpringBoot.SpringBootApiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
//La anterior linea permite que las peticiones que vienen desde http://localhost:4200 accedan a los endpoints de este controlador.
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    // postMapin solo es el nombre de lo que hara la peticion
    // El requestBody indica por donde se van a enviar el objeto que se guardara
    @PostMapping()
    public UsuarioModel setUsuario(@RequestBody UsuarioRequestDTO usuario){
        return usuarioService.agregarUsuario(usuario);
    }

    // Obtener por Id
    @GetMapping(path = "/{id}")
    // la cual sera /usuario/1     el 1 sera el id
    // no se usa requestBody porque requestBody es mas que todo para guardar datos y pathvariable es para
    // consultar datos en base a una query
    //  el valor que mandemos por ruta se agregara a long id y este pasara como argumento del metodo
    public Optional<UsuarioModel> getById(@PathVariable("id") long id){
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/porEstado/query")
    public Optional<ArrayList<UsuarioModel>> getByEstado(@RequestParam("idEstado") long idEstado){
        return usuarioService.obtenerPorEstado(idEstado);
    }

    @GetMapping(path = "/porPais/query")
    public ArrayList<UsuarioModel> getByPais(@RequestParam("idPais") long idPais){
        return usuarioService.obtenerPorPais(idPais);
    }
    /* @RequestParam es ideal para filtrar realizar busquedas  opciones de consulta
     * http://localhost:4001/usuario/porPais/query?idPais=1
     * donde idPais=1 es el parámetro que pide el RequestParam para convertilos a longIdPais
    */

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") long id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if(ok){
            return "El usuario se ah eliminado correctamente";
        }else{
            return "Error eliminando este usuario";
        }
    }
}

// Nota: para enviar el recuestBody de un usuario que tiene una entidad relacional en la api
// se hace de la siguienet manera tomando como ejemplo el proyecto actual y el controlador de usuarios
// tambien podemos crear un DTO para en la peticion sneivar solo enviar id;

/*  {
        "nombre": "Euclides",
        "apellido": "Perez",
        "edad": 26,
        "email": "euclides2696@gmail.com",
        "prioridad": 1,
        "pais":{
            "id":1
        },
        "estado":{
            "id":1
        }
    }
*/
/* Con DTO
 * {
    "nombre": "Elcy",
    "apellido": "Perez",
    "edad": 26,
    "email": "elcy@gmail.com",
    "prioridad": 1,
    "paisId": 5,
    "estadoId": 1818
}
* */