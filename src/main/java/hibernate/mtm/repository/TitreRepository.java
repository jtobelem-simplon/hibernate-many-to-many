package hibernate.mtm.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import hibernate.mtm.model.Titre;

public interface TitreRepository extends CrudRepository<Titre, Long> {
	
	Collection<Titre> findByNomLike(String nom);

}
