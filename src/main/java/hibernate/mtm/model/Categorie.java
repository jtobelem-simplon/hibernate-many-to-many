package hibernate.mtm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorie {

	@Id
	private long id;
	
	private String libelle;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	// optionnellement un lien vers une collection de titres
	
	
	
}
