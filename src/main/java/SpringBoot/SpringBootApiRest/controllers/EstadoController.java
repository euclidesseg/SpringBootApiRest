package SpringBoot.SpringBootApiRest.controllers;

import SpringBoot.SpringBootApiRest.models.EstadoModel;
import SpringBoot.SpringBootApiRest.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoService estadosRepository;
    @Autowired EstadoService estadoService;

    @GetMapping("/query")
    // aceder a la ruta
    // /estados/query?idPais=82
    private ArrayList<EstadoModel> getByPais(@RequestParam("idPais") long idPais){
        return estadosRepository.obtenerPorPais(idPais);
    }

    @PostMapping()
    public EstadoModel setEstado(@RequestBody EstadoModel estadoModel){
        return this.estadoService.guardarEstado(estadoModel);
    }
}
