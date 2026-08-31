package SpringBoot.SpringBootApiRest.services;

import SpringBoot.SpringBootApiRest.models.PaisModel;
import SpringBoot.SpringBootApiRest.repositories.IPaisRepository;
import SpringBoot.SpringBootApiRest.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

    private final IPaisRepository paisRepository;
    public PaisService(IPaisRepository paisRepository){
        this.paisRepository = paisRepository;
    }
    // Spring inyecta automáticamente la implementación de IPaisRepository mediante el constructor.
    // Por eso no necesitamos crear manualmente PaisService con "new" desde PaisController.
    // Spring se encarga de crear y conectar las dependencias necesarias.

    public PaisModel setPais(PaisModel pais){
        return this.paisRepository.save(pais);
    }
}
