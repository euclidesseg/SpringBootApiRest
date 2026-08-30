package SpringBoot.SpringBootApiRest.repositories;

import SpringBoot.SpringBootApiRest.models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IEstadoRepository extends JpaRepository<EstadoModel, Long> {
    public abstract ArrayList<EstadoModel> findByPaisId(long idPais);
}

// Notas
/*
 * Spring Data JPA utiliza una convención de nombres para construir
 * automáticamente consultas a partir del nombre del método.
 *
 * findByPaisId se interpreta como:
 * "Buscar todos los EstadoModel donde pais.id sea igual al valor recibido".
 *
 * "pais" es la propiedad de EstadoModel que representa la relación ManyToOne con PaisModel.
 * "id" es la propiedad de PaisModel.
 *
 *  Se puede leer como
 *  find → buscar
 *  By   → donde
 *  Pais → propiedad "pais" de EstadoModel
 *  Id   → propiedad "id" de PaisModel
 */