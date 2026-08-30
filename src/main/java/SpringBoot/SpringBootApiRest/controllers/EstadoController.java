package SpringBoot.SpringBootApiRest.controllers;

import SpringBoot.SpringBootApiRest.models.EstadoModel;
import SpringBoot.SpringBootApiRest.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoService estadosRepository;

    @GetMapping("/query")
    // aceder a la ruta
    // /estados/query?idPais=82
    private ArrayList<EstadoModel> getByPais(@RequestParam("idPais") long idPais){
        return estadosRepository.obtenerPorPais(idPais);
    }
}
