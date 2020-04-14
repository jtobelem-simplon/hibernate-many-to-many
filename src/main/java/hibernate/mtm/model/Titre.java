package hibernate.mtm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Titre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    // Pour supprimer des titres associés à des auteurs (manyToMany), deux options à placer dans la classe qu'on veut pouvoir supprimer :
    // **** Option1 - @OnDelete(action = OnDeleteAction.CASCADE) : utilise le mecanisme db : https://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/annotations/OnDeleteAction.html
    // **** Option2 - @ManyToMany(mappedBy="titres", cascade = CascadeType.REMOVE)
    // ?? https://thoughts-on-java.org/hibernate-tips-the-best-way-to-remove-entities-from-a-many-to-many-association/
    @ManyToMany(mappedBy = "titres")
    @OnDelete(action = OnDeleteAction.CASCADE)
    // Pour éviter des infos cycliques lors de la sérialisation, deux options
    // **** Option1 - on ne garde que les id d'un côté de la relation (et pas tout l'objet) https://stackoverflow.com/questions/33475222/spring-boot-jpa-json-without-nested-object-with-onetomany-relation
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//	@JsonIdentityReference(alwaysAsId = true)
    // **** Option2 - on ignore un côté de la relation lors de la sérialisation https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    // **** Option3 - jsconBackReference : pas très interessant
    // **** Option4 - jsonIgnore : ignore competement l'attribut lors de la serialisation
//    @JsonIgnoreProperties("titres")
    private Set<Auteur> auteurs = new HashSet<>();

    // Pour supprimer une categorie associée à des titres (oneToMany), trois options :
    // **** Option1 - @OnDelete(action = OnDeleteAction.CASCADE) : utilise le mecanisme db : https://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/annotations/OnDeleteAction.html
    // **** Option2 - @OneToMany(mappedBy = "categorie", cascade = CascadeType.REMOVE) dans la classe categorie
    // **** Option3 - @OneToMany(mappedBy = "categorie", orphanRemoval = true) dans la classe categorie
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    private Categorie categorie;

    public Titre(String nom, Categorie categorie) {
        this.nom = nom;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Titre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
