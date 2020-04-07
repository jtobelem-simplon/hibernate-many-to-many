package hibernate.mtm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String libelle;

    // Optionnellement, on peut ajouter l'autre direction de la relation : un lien vers une collection de titres
    // Pour supprimer une categorie associée à des titres (oneToMany), trois options : (voir option 1 dans Titre)
    // **** Option2 - @OneToMany(mappedBy = "categorie", cascade = CascadeType.REMOVE)
    // **** Option3 - @OneToMany(mappedBy = "categorie", orphanRemoval = true)
    // difference entre option2 et 3 : https://stackoverflow.com/a/18813411/10364570
//    @OneToMany(mappedBy = "categorie")
//    private Set<Titre> titres = new HashSet<>();

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
