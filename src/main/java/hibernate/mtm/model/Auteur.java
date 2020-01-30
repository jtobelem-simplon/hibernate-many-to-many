package hibernate.mtm.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Auteur {

	@Id
	private long id;
	
	private String nom;
	
	private String prenom;
	
	@ManyToMany
	private Collection<Titre> ouvrages;

}
