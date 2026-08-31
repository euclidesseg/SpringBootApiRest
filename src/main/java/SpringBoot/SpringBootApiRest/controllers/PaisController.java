package SpringBoot.SpringBootApiRest.controllers;

import SpringBoot.SpringBootApiRest.models.PaisModel;
import SpringBoot.SpringBootApiRest.services.PaisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {

    public final PaisService paisService;
    public  PaisController(PaisService paisService){
        this.paisService = paisService;
    }
    @PostMapping()
    public PaisModel setPais(@RequestBody PaisModel paisModel){
        return this.paisService.setPais(paisModel);
    }
}
