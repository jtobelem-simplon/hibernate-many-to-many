package hibernate.mtm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String libelle;

    // Optionnellement, on peut ajouter l'autre direction de la relation : un lien vers une collection de titres
//	@OneToMany(mappedBy = "categorie")
//	private Set<Titre> titres = new HashSet<>();

    public Categorie(String libelle) {
        this.libelle = libelle;
    }


}
