package SpringBoot.SpringBootApiRest.repositories;


import SpringBoot.SpringBootApiRest.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    // <UsuarioModel, Long> indica el tipo de identidad que se va a manejar en este
    // repositorio
    // Longo se refiere al tipo de datos del identificador unico de mi tabla
    // UsuarioModel
    // Jpa repository es una implementacion de crudrepository que nos proporciona metodos para
    // consultar a la base de datos

    public abstract ArrayList<UsuarioModel> findByPaisId(long idPais);
    public abstract Optional<ArrayList<UsuarioModel>> findByEstadoId(long idEstado);
}
