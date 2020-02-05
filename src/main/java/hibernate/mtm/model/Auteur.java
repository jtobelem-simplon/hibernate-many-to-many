package hibernate.mtm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	
	private String prenom;
	
	@ManyToMany
	@JsonIgnoreProperties("auteurs")
	// https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	private Set<Titre> ouvrages = new HashSet<>();

	public Auteur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public void addTitre(Titre titre) {
		ouvrages.add(titre);
		
		// comme la relation est bidirectionnelle, il faut aussi ajouter l'auteur dans liste des auteurs du titre
		titre.getAuteurs().add(this);
	}
	
	

}
