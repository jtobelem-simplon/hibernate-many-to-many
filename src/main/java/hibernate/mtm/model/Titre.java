package hibernate.mtm.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Titre {
	
	@Id
	private long id;
	
	private String nom;
	
	// pour éviter des infos cycliques lors de la sérialisation, deux options
	@ManyToMany(mappedBy="ouvrages")
	// Option1 - on ne garde que les id d'un côté de la relation (et pas tout l'objet)
	// https://stackoverflow.com/questions/33475222/spring-boot-jpa-json-without-nested-object-with-onetomany-relation
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//	@JsonIdentityReference(alwaysAsId = true)
	// Option2 - on ignore un côté de la relation lors de la sérialisation
	// https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	@JsonIgnoreProperties("ouvrages")
	private Set<Auteur> auteurs;
	
	@ManyToOne
    @JoinColumn(name = "categorie", referencedColumnName = "id")
	private Categorie categorie;
}
