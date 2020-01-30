package hibernate.mtm.model;

import java.util.Set;

import javax.persistence.Entity;
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
	private long id;
	
	private String nom;
	
	private String prenom;
	
	@ManyToMany
	@JsonIgnoreProperties("auteurs")
	// https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	private Set<Titre> ouvrages;

}
