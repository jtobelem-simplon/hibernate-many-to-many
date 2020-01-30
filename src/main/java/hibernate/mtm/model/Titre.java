package hibernate.mtm.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Titre {
	
	@Id
	private long id;
	
	private String nom;
	
	@ManyToMany(mappedBy="ouvrages")
	private Collection<Auteur> auteurs;
	
	@ManyToOne
    @JoinColumn(name = "categorie", referencedColumnName = "id")
	private Categorie categorie;
}
