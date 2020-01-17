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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
