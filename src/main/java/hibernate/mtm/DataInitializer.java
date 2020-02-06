package hibernate.mtm;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import hibernate.mtm.model.Auteur;
import hibernate.mtm.model.Categorie;
import hibernate.mtm.model.Titre;
import hibernate.mtm.repository.AuteurRepository;
import hibernate.mtm.repository.CategorieRepository;
import hibernate.mtm.repository.TitreRepository;

/**
 * Cette classe est chargée au lancement de l'application. Elle sert à
 * enregistrer des données en base.
 * 
 * @author Josselin Tobelem
 *
 */
@Component
public class DataInitializer {

	private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

	private AuteurRepository auteurRepository;
	private CategorieRepository categorieRepository;
	private TitreRepository titreRepository;

	public DataInitializer(final AuteurRepository auteurRepository, final CategorieRepository categorieRepository,
			final TitreRepository titreRepository) {
		this.auteurRepository = auteurRepository;
		this.categorieRepository = categorieRepository;
		this.titreRepository = titreRepository;
	}

	/**
	 * Crée des categories, des titres et des auteurs et les fait persister en base
	 * par les repositories.
	 */
	public void initData() {

		try {
			Categorie recueil = new Categorie("recueil");
			Categorie essai = new Categorie("essai");
			Categorie roman = new Categorie("roman");

			Auteur breton = new Auteur("Breton", "André");
			Auteur calvino = new Auteur("Calvino", "Italo");
			Auteur desplechin = new Auteur("Desplechin", "Marie");
			Auteur violet = new Auteur("Violet", "Lydie");
			Auteur soupault = new Auteur("Soupault", "Philippe");

			Titre champs = new Titre("Les Champs magnétiques", recueil);
			// important : la méhotde addTitre implémente les deux côtés de la relation
			breton.addTitre(champs);
			soupault.addTitre(champs);

			Titre manifeste = new Titre("Manifeste du surréalisme", essai);
			breton.addTitre(manifeste);

			Titre baron = new Titre("Le baron perché", roman);
			calvino.addTitre(baron);

			Titre contes = new Titre("Contes italiens", roman);
			calvino.addTitre(contes);

			Titre vie = new Titre("La Vie sauve", essai);
			desplechin.addTitre(vie);
			violet.addTitre(vie);

			if (!categorieRepository.findAll().iterator().hasNext()) {
				categorieRepository.saveAll(Arrays.asList(roman, recueil, essai));
			}
			if (!titreRepository.findAll().iterator().hasNext()) {
				titreRepository.saveAll(Arrays.asList(manifeste, contes, vie, baron, champs));
			}
			if (!auteurRepository.findAll().iterator().hasNext()) {
				auteurRepository.saveAll(Arrays.asList(calvino, violet, desplechin, breton, soupault));
			}

		} catch (final Exception ex) {
			logger.error("Exception while inserting mock data {}", ex);
		}

	}

}
