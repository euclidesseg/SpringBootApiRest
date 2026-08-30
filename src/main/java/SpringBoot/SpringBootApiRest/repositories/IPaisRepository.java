package SpringBoot.SpringBootApiRest.repositories;

import SpringBoot.SpringBootApiRest.models.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository<PaisModel, Long> {
}
