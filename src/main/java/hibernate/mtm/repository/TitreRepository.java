package hibernate.mtm.repository;

import org.springframework.data.repository.CrudRepository;

import hibernate.mtm.model.Titre;

public interface TitreRepository extends CrudRepository<Titre, Long> {

}
