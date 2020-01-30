package hibernate.mtm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categorie {

	@Id
	private long id;
	
	private String libelle;

	// optionnellement un lien vers une collection de titres
}
