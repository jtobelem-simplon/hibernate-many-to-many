package hibernate.mtm.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Auteur {

	@Id
	private long id;
	
	private String nom;
	
	private String prenom;
	
	@ManyToMany
	private Collection<Titre> ouvrages;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Collection<Titre> getOuvrages() {
		return ouvrages;
	}

	public void setOuvrages(Collection<Titre> ouvrages) {
		this.ouvrages = ouvrages;
	}
	
	
	
	
}
