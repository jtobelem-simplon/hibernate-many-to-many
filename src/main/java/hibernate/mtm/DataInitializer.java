package hibernate.mtm;

import hibernate.mtm.model.Auteur;
import hibernate.mtm.model.Categorie;
import hibernate.mtm.model.Titre;
import hibernate.mtm.repository.AuteurRepository;
import hibernate.mtm.repository.CategorieRepository;
import hibernate.mtm.repository.TitreRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Cette classe est chargée au lancement de l'application. Elle sert à
 * enregistrer des données en base.
 *
 * @author Josselin Tobelem
 */
@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private final AuteurRepository auteurRepository;
    private final CategorieRepository categorieRepository;
    private final TitreRepository titreRepository;

    /**
     * Crée des categories, des titres et des auteurs et les fait persister en base
     * par les repositories.
     */
    public void initData() {

        try {
            Categorie recueil = new Categorie("recueil");
            Categorie essai = new Categorie("essai");
            Categorie roman = new Categorie("roman");

            Auteur breton = new Auteur("Breton", "André",
                    "André Breton, né à Tinchebray dans l'Orne le 19 février 1896 et mort à Paris le 28 septembre 1966, est un poète et écrivain français, principal animateur et théoricien du surréalisme.\n" +
                            "\n" +
                            "Auteur des livres Nadja, L'Amour fou et des différents Manifestes du surréalisme, son rôle de chef de file du mouvement surréaliste, et son œuvre critique et théorique pour l'écriture et les arts plastiques, font d'André Breton une figure majeure de l'art et de la littérature française du xxe siècle.",
                    "https://upload.wikimedia.org/wikipedia/commons/f/f2/Andr%C3%A9_Breton_-_photo_Henri_Manuel.jpg");

            Auteur calvino = new Auteur("Calvino", "Italo",
                    "Italo Calvino, né le 15 octobre 1923 à Santiago de Las Vegas (Cuba) et mort le 19 septembre 1985 à Sienne (Italie), est un écrivain italien et un philosophe du xxe siècle.\n" +
                            "\n" +
                            "Calvino est à la fois un théoricien de la littérature, un écrivain réaliste, mais aussi et surtout, pour le grand public, un fabuliste plein d'humour : sa production très riche fait de lui l'un des plus grands écrivains italiens de la période moderne.",
                    "https://upload.wikimedia.org/wikipedia/commons/9/97/Italo-Calvino.jpg");

            Auteur desplechin = new Auteur("Desplechin", "Marie",
                    "Marie Desplechin, née le 7 janvier 1959 à Roubaix, est une journaliste et écrivaine française, autrice de livres pour enfants et pour adultes. Elle participe également à l'écriture de scénarios.",
                    "https://upload.wikimedia.org/wikipedia/commons/a/a1/Montreuil_-_Salon_du_livre_jeunesse_2011_-_Marie_Desplechin_-_001.jpg");

            Auteur violet = new Auteur("Violet", "Lydie",
                    "Attachée de presse dans plusieurs maisons d'édition, Lydie Violet est prise d'une crise convulsive dans son bureau des éditions Grasset, en août 2001.\n" +
                            "\n" +
                            "Très vite, elle apprend qu'elle souffre d'un cancer du cerveau. Elle a alors 39 ans.\n" +
                            "\n" +
                            "Elle décide de mettre par écrit son histoire grâce à la plume de son amie Marie Desplechin, dans un livre-témoignage, faisant preuve d'un humour ravageur à la fois tendre et enragé : 'La Vie sauve'.\n" +
                            "\n" +
                            "La Vie sauve remporte en novembre 2005 le prix Médicis essais.\n",
                    "https://www.babelio.com/users/AVT_Lydie-Violet_7330.jpeg");

            Auteur soupault = new Auteur("Soupault", "Philippe",
                    "Philippe Soupault, né à Chaville le 2 août 1897 et mort à Paris XVIe le 12 mars 1990, est un poète français, cofondateur du surréalisme et journaliste. Il est inhumé au cimetière de Montmartre (17e division).",
                    "https://upload.wikimedia.org/wikipedia/commons/5/56/Robert_Delaunay_-_le_po%C3%A8te_Philippe_Soupault.jpg");

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
            logger.error("Exception while inserting mock data {0}", ex);
        }
    }

    private void deleteAll() {
        titreRepository.deleteAll();
        auteurRepository.deleteAll();
        categorieRepository.deleteAll();
    }


    /**
     * supprime le premier element de la liste
     */
    private void testDeleteCategorieFirst() {
        if (categorieRepository.findAll().iterator().hasNext()) {
            logger.info("\n******** Avant Delete ***********");
            logCreated();
            long id = categorieRepository.findAll().iterator().next().getId();
            categorieRepository.deleteById(id);
            logger.info("\n******** Après Delete ***********");
            logCreated();
        }
    }

    /**
     * supprime le premier element de la liste
     */
    private void testDeleteAuthorFirst() {
        if (auteurRepository.findAll().iterator().hasNext()) {
            logger.info("\n******** Avant Delete ***********");
            logCreated();
            long id = auteurRepository.findAll().iterator().next().getId();
            auteurRepository.deleteById(id);
            logger.info("\n******** Après Delete ***********");
            logCreated();
        }
    }

    /**
     * supprime le premier element de la liste
     */
    private void testDeleteTitreFirst() {
        if (titreRepository.findAll().iterator().hasNext()) {
            logger.info("\n******** Avant Delete ***********");
            logCreated();
            long id = titreRepository.findAll().iterator().next().getId();
            titreRepository.deleteById(id);
            logger.info("\n******** Après Delete ***********");
            logCreated();
        }
    }

    public void logCreated() {
        titreRepository.findAll().forEach(elem -> logger.info(elem.toString()));
        auteurRepository.findAll().forEach(elem -> logger.info(elem.toString()));
        categorieRepository.findAll().forEach(elem -> logger.info(elem.toString()));
    }

    @Override
    public void run(String... args) {

        logger.info("\n******** Initializing Data ***********");
        deleteAll();
        initData();
        logCreated();
        logger.info("\n******** Data initialized ***********");

//        testDeleteAuthorFirst();
//        testDeleteTitreFirst();
//        testDeleteCategorieFirst();
    }
}
