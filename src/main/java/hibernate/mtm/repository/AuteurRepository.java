package hibernate.mtm.repository;

import hibernate.mtm.model.Auteur;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur, Long> {

}
