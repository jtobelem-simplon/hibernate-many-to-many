package hibernate.mtm.repository;

import hibernate.mtm.model.Titre;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TitreRepository extends CrudRepository<Titre, Long> {

    Collection<Titre> findByNomLike(String nom);

}
