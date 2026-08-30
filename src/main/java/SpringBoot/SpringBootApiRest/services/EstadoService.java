package SpringBoot.SpringBootApiRest.services;


import SpringBoot.SpringBootApiRest.models.EstadoModel;
import SpringBoot.SpringBootApiRest.repositories.IEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstadoService {
    // @Autowired nos permite que no tengamos que instanciar la variable de esta
    // manera
    // IEstadoRepository estadorepository = new IEstadoRepository();
    @Autowired
    IEstadoRepository estadorepository;


    // primer metodo obtener
    public ArrayList<EstadoModel> obtenerEstados(){
        return(ArrayList<EstadoModel>)estadorepository.findAll();
    }

    //metodo para guardar
    public EstadoModel guardarEstado(EstadoModel estado){
        return estadorepository.save(estado);
    }

    public Optional<EstadoModel> obtenerPorId(long id){
        return this.estadorepository.findById(id);
    }
    public ArrayList<EstadoModel> obtenerPorPais(long idPais){
        return estadorepository.findByPaisId(idPais);
    }

    public boolean eliminarEstado(long id){
        try{
            estadorepository.deleteById(id);
            return true;
        }catch(Error error){
            return false;
        }
    }
}
