INSERT INTO db_livres.auteur (id, nom, prenom)
VALUES (1, 'Breton', 'André');
INSERT INTO db_livres.auteur (id, nom, prenom)
VALUES (2, 'Soupault', 'Philippe');
INSERT INTO db_livres.auteur (id, nom, prenom)
VALUES (3, 'Calvino', 'Italo');
INSERT INTO db_livres.auteur (id, nom, prenom)
VALUES (4, 'Desplechin', 'Marie');
INSERT INTO db_livres.auteur (id, nom, prenom)
VALUES (5, 'Violet', 'Lydie');

INSERT INTO db_livres.categorie (id, libelle)
VALUES (1, 'recueil');
INSERT INTO db_livres.categorie (id, libelle)
VALUES (2, 'roman');
INSERT INTO db_livres.categorie (id, libelle)
VALUES (3, 'essai');

INSERT INTO db_livres.titre (id, categorie, nom)
VALUES (1, 1, 'Les Champs magnétiques');
INSERT INTO db_livres.titre (id, categorie, nom)
VALUES (2, 2, 'Le baron perché');
INSERT INTO db_livres.titre (id, categorie, nom)
VALUES (3, 3, 'La Vie sauve');
INSERT INTO db_livres.titre (id, categorie, nom)
VALUES (4, 2, 'Contes italiens');
INSERT INTO db_livres.titre (id, categorie, nom)
VALUES (5, 3, 'Manifeste du surréalisme');

INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (1, 1);
INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (2, 1);
INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (3, 2);
INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (4, 3);
INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (5, 3);
INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (3, 4);
INSERT INTO db_livres.auteur_titres (auteurs_id, titres_id)
VALUES (1, 5);
