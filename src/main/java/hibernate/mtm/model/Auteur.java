package hibernate.mtm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String photoUrl;

    // Voir Titre pour supprimer des titres associés à des auteurs
    @ManyToMany
    // Voir Titre pour éviter les infos cycliques
    @JsonIgnoreProperties("auteurs")
    private Set<Titre> titres = new HashSet<>();

    public Auteur(String nom, String prenom, String description, String photoUrl) {
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public void addTitre(Titre titre) {
        titres.add(titre);

        // comme la relation est bidirectionnelle, il faut aussi ajouter l'auteur dans liste des auteurs du titre
        titre.getAuteurs().add(this);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
