https://documenter.getpostman.com/view/6373510/SWT5j1LL# hibernate-many-to-many


Dans ce projet, on veut représenter les données suivantes :
[data](data.csv)

On va donc implémenter quatre tables et une relation one-to-many et une relation many-to-many :

![eer](eer.png)

#### Spring/hibernate

On va réaliser uniquement les controllers de base du backend. Grâce à la dépéndance `org.springframework.boot:spring-boot-starter-data-rest`, les fonctions du repository seront directement exposées comme endpoints de l'application.

#### Postman

On peut tester les endpoints de l'application avec la collection suivante : 
[![Run in Postman](https://run.pstmn.io/button.svg)](https://documenter.getpostman.com/view/6373510/SWT5j1VH?version=latest)

*NB : on peut convertir simplement des requetes cURL sous postman avec le bouton import*

#### Référence

La création de ce repo est faite à partir du guide officiel dans lequel on peut trouver d'autres éléments intéressants (comme l'exposition d'une requête personnalisée du repo dans le controller et son utilisation avec cURL)

<https://spring.io/guides/gs/accessing-data-rest/>

